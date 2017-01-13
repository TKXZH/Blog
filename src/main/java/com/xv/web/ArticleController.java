package com.xv.web;

import com.xv.Exception.ArticleRelatedException;
import com.xv.dto.ArticleAuthorCategoriesDto;
import com.xv.dto.ArticlesCategoriesDto;
import com.xv.dto.AuthorCategoryDto;
import com.xv.dto.JsonDto;
import com.xv.entity.Article;
import com.xv.entity.Category;
import com.xv.entity.User;
import com.xv.service.ArticleService;
import com.xv.service.CategoryService;
import com.xv.service.UserService;
import com.xv.web.auth.AuthPassport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xvzh on 2016/12/29.
 */


@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public static String mainPage() {
        return "redirect:/1010/articles/show";
    }

    @RequestMapping(value = "/{uid}/articles/show", method = RequestMethod.GET)
    public String showArticles(@PathVariable("uid") long uid, Model model) {
        List<Category> categories = categoryService.getCategoriesByUid(uid);
        User author = userService.getUserById(uid);
        ArticlesCategoriesDto acDto = new ArticlesCategoriesDto(author, categories);
        model.addAttribute("acDto", acDto);
        //为主页下的服务统一加上博主信息
        model.addAttribute("user", author);
        return "article_visitor";
    }

    @ResponseBody
    @RequestMapping(value = "/{uid}/articles/showJ", method = RequestMethod.GET)
    public Object showArticlesJ(@PathVariable("uid") long uid) {
        List<Article> articles = articleService.getAllArticles(uid);
        return articles;
    }
    @AuthPassport(true)
    @RequestMapping(value = "/{uid}/articles/admin", method = RequestMethod.GET)
    public String showArticles(@PathVariable("uid") long uid, Model model, HttpSession session) {
        long uidFromSession = ((User)session.getAttribute("user")).getId();
        if(uidFromSession != uid) {
            throw new ArticleRelatedException("用户伪造请求");
        }
        List<Article> articles = articleService.getAllArticles(uid);
        model.addAttribute("articles", articles);
        return "article_admin";
    }

    /**
     * 供ajax执行文章删除操作
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "/articles/{articleId}/delete", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteArticle(@PathVariable("articleId") long id, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return new JsonDto(false,"用户未登录");
        }
        long uid = user.getId();
        try {
            articleService.delete(id, uid);
        } catch (Exception e) {
            return new JsonDto(false,"删除失败");
        }
        return new JsonDto(true,"删除成功");
    }

    @AuthPassport(true)
    @RequestMapping(value = "/articles/new", method = RequestMethod.GET)
    public String createArticle(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Category> categories = categoryService.getCategoriesByUid(user.getId());
        model.addAttribute("categories", categories);
        return "article_new";
    }

    /**
     * 供ajax创建文章调用
     * @param session
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/articles/new", method = RequestMethod.POST)
    public Object createArticle(HttpSession session, Article article) {
        User user = (User)session.getAttribute("user");
        if(user == null) {
            return new JsonDto(false,"文章创建失败");
        }
        long uid = user.getId();
        article.setUid(uid);
        try{
            articleService.createArticle(article);
        } catch (Exception e) {
            return new JsonDto(false,"创建文章失败");
        }
        return new JsonDto(true, "文章创建成功");

    }

    @AuthPassport(true)
    @RequestMapping(value = "articles/{articleId}/modify", method = RequestMethod.GET)
    public String modifyArticle(@PathVariable("articleId") long articleId, HttpSession session, Model model) {
        long uid = (Long)session.getAttribute("token");
        Article article = articleService.getArticleById(articleId);
        long authorId = article.getUid();
        if(authorId != uid) {
            return "redirect:/login";
        }
        model.addAttribute("article", article);
        return "article_modify";
    }

    @AuthPassport(true)
    @RequestMapping(value = "articles/{articleId}/modify", method = RequestMethod.POST)
    public String modifyArticle(@PathVariable("articleId") long articleId, HttpSession session, Article articleModified) {
        long uid = (Long)session.getAttribute("token");
        Article article = articleService.getArticleById(articleId);
        long authorId = article.getUid();
        if(authorId != uid) {
            return "redirect:/login";
        }
        article.setId(articleId);
        article.setUid(uid);
        articleService.modifyArticle(article);
        return "redirect:/" + uid + "/articles";
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/articles/{articleId}/support", method = RequestMethod.GET)
    public Object support(HttpSession session, @PathVariable("articleId") long id) {
        /*如果该用户没有在此次访问中没有对此文章点过赞，才允许点赞*/
        if(session.getAttribute("supported") == null) {
            try {
                Set<Long> set = new HashSet<Long>();
                set.add(id);
                articleService.star(id);
                session.setAttribute("supported", set);
            } catch (Exception e) {
                return new JsonDto(false, "点赞失败");
            }
            return new JsonDto(true, "点赞成功");
        }

        Set<Long> set = (Set) session.getAttribute("supported");
        if(set.contains(id)) {
            return new JsonDto(false, "重复点赞");
        } else {
            set.add(id);
            articleService.star(id);
            return new JsonDto(true, "点赞成功");
        }
    }

    @RequestMapping(value = "/articles/{articleId}/detail", method = RequestMethod.GET)
    public String showArticleDetail(@PathVariable("articleId") long id, Model model) {
        Article article = articleService.getArticleById(id);
        User user = userService.getUserById(article.getUid());
        Category category = categoryService.getCategoryById(article.getCategory());
        List<Category> categories = categoryService.getCategoriesByUid(user.getId());
        ArticleAuthorCategoriesDto aacDto = new ArticleAuthorCategoriesDto(article, user, category, categories);
        model.addAttribute("aacDto", aacDto);
        //为主页下的服务统一加上博主信息
        model.addAttribute("user", user);
        return "article_detail";
    }

    @RequestMapping(value = "/categories/{categoryId}/show", method = RequestMethod.GET)
    public String getArticlesByCategoryId(@PathVariable("categoryId") long categoryId, Model model) {
        Category category = categoryService.getCategoryById(categoryId);
        User user = userService.getUserById(category.getUid());
        List<Category> categories = categoryService.getCategoriesByUid(user.getId());
        AuthorCategoryDto acDto = new AuthorCategoryDto(category, user, categories);
        model.addAttribute("acDto", acDto);
        //为主页下的服务统一加上博主信息
        model.addAttribute("user", user);
        return "article_category";
    }

    @RequestMapping(value = "/categories/{categoryId}/showJ", method = RequestMethod.GET)
    @ResponseBody
    public Object getArticlesByCategoryId(@PathVariable("categoryId") long categoryId) {
        return articleService.getArticlesByCategoryId(categoryId);
    }
}
