package com.rookie.stack.xpu.common.utils;

import com.rookie.stack.xpu.common.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.Date;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
public final class JwtUtil {
    private final static String secretKey = "blueBird";

    private final static Duration expiration = Duration.ofHours(2);

    public static String generate(String userId) {
        Date expireDate = new Date(System.currentTimeMillis() + expiration.toMillis());
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
    public static Claims parse(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (JwtException e){
            throw new BusinessException("jwt 解析出错");
        }
        return claims;
    }
}
