package com.example.onlinestoredemo.utils;

import com.example.onlinestoredemo.model.entity.User;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @ClassName JwtUtil
 * @Description JWT工具类
 * 1.生成的token，是可以通过base64进行解密出明文信息
 * 2.base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3.无法作废已颁布的令牌，除非改密钥
 * @Author ZhangJia
 * @Date 2020/9/11
 * @Version 1.0
 **/
public class JwtUtils {

    /**
     * 过期时间，一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7;

    /**
     * 加密密钥
     */
    private static final String SECRET = "CathyJia";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "Cathy";

    /**
     * subject(主题)
     */
    private static final String SUBJECT = "Cathy";

    /**
     * 根据用户信息，生成令牌
     * @param user 用户信息
     * @return java.lang.String
     * @Exception 
     **/
    public static String geneJsonWebToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token的方法
     * @param token token
     * @return io.jsonwebtoken.Claims
     * @Exception 
     **/
    public static Claims checkJwt(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
