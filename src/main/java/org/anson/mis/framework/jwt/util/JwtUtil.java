package org.anson.mis.framework.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.anson.mis.framework.jwt.entity.JwtEntity;
import org.anson.mis.util.id.IdWorker;

import java.util.Date;

/**
 * jwt 工具类
 */
public class JwtUtil {


    public static String createToken(JwtEntity jwtEntity, String secret) {
        if(jwtEntity == null){
            throw new RuntimeException("jwtEntity is null");
        }

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + jwtEntity.getTokenTTL();
        Date exp = new Date(expMillis);
        long rfExpMillis = nowMillis + jwtEntity.getRefreshTokenTTL();
        Date rfExp = new Date(rfExpMillis);

        return JWT.create()
                .withJWTId(IdWorker.getId().toString())
                .withIssuer(jwtEntity.getIssuer())
                .withSubject(jwtEntity.getSubject())
                .withAudience(jwtEntity.getAudience())
                .withIssuedAt(now)
                .withExpiresAt(exp)
                .withClaim("userNo", jwtEntity.getUserNo())
                .withClaim("refreshTokenExp", rfExp)
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 解码 token
     * @param token
     * @return
     */
    public static DecodedJWT decodeToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt;
        } catch (JWTDecodeException exception){
            return null;
        }
    }
}
