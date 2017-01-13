package com.xv.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xvzh on 2016/12/27.
 */
public class TokenManager {
    private static Map<Long, Token> tokenMap = new HashMap<Long, Token>();

    /**
     * 根据用户id创建token
     * @param uid
     * @return
     */
    public static String createToken(long uid) {
        Token token = new Token(uid);
        tokenMap.put(uid, token);
        return token.tokenStr;
    }

    /**
     * 根据token检索用户
     * @param tokenStr
     * @return
     */
    public static Long checkUserByToken(String tokenStr) {
        Set<Long> set = tokenMap.keySet();
        for(long key : set) {
            Token token = tokenMap.get(key);
            if(token.tokenStr.equals(tokenStr) && token.isInLimit()) {
                return key;
            }
        }
        return null;
    }
}

class Token {
    String tokenStr;
    Date expireTime;
    //加盐防止彩虹
    private static String salt = "xvzh19941031+++---";
    public Token(long uid) {
        String tokenStr = MD5.toMd5(uid + salt);
        this.tokenStr = tokenStr;
        long timeStamp = new Date().getTime() + 1000000;
        this.expireTime = new Date(timeStamp);
    }

    /**
     * 此token是否在可用期限内
     * @return
     */
    public boolean isInLimit() {
        if(expireTime.after(new Date())) {
            return true;
        }   else {
            return false;
        }
    }
}
