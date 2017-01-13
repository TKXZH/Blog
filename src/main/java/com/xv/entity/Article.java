    package com.xv.entity;

    import java.util.Date;

    /**
     * Created by xvzh on 2016/12/27.
     */
    public class Article {
        public Article(){}
        public Article(long uid, long category, String content) {
            this.uid = uid;
            this.category = category;
            this.content = content;
        }
        private long id;
        private long uid;
        private long category;
        private String content;
        private Date createTime;
        private int star;
        private String title;
        private String description;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public long getCategory() {
            return category;
        }

        public void setCategory(long category) {
            this.category = category;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            if(content.equals("")) {
                return;
            }
            this.content = content;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            if(title.equals("")) {
                return;
            }
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            if(description.equals("")) {
                return;
            }
            this.description = description;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "id=" + id +
                    ", uid=" + uid +
                    ", category='" + category + '\'' +
                    ", content='" + content + '\'' +
                    ", createTime=" + createTime +
                    ", star=" + star +
                    '}';
        }
    }
