package org.anson.mis.framework.auth.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

/**
 * Jwt 工具类
 */
public class JwtUtil {

    public static String createToken(String jwtId, String issuer, String subject, String audience,
                                     Date issuedAt, Date expiresAt, Map<String, Object> claimMap, String secret)
    {
         JWTCreator.Builder builder = JWT.create()
                                            .withJWTId(jwtId)
                                            .withIssuer(issuer)
                                            .withSubject(subject)
                                            .withAudience(audience)
                                            .withIssuedAt(issuedAt)
                                            .withExpiresAt(expiresAt);

        Set<Map.Entry<String, Object>> entries = claimMap.entrySet();
        Iterator<Map.Entry<String, Object>> iteratorMap = entries.iterator();

        while(iteratorMap.hasNext()){
            Map.Entry<String, Object> next = iteratorMap.next();

            if(next.getValue() instanceof String){
                builder = builder.withClaim(next.getKey(), (String) next.getValue());
            }else if(next.getValue() instanceof Integer){
                builder = builder.withClaim(next.getKey(), (Integer) next.getValue());
            }else if(next.getValue() instanceof Date){
                builder = builder.withClaim(next.getKey(), (Date) next.getValue());
            }else if(next.getValue() instanceof Long){
                builder = builder.withClaim(next.getKey(), (Long) next.getValue());
            }else if(next.getValue() instanceof Boolean){
                builder = builder.withClaim(next.getKey(), (Boolean) next.getValue());
            }else if(next.getValue() instanceof Double){
                builder = builder.withClaim(next.getKey(), (Double) next.getValue());
            }
        }

        try{
            return builder.sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception){
            throw new RuntimeException("You need to enable Algorithm.HMAC256");
        }
    }

    /**
     * 解码token
     * @param token
     * @return
     */
    public static DecodedJWT decodeToken(String token)
    {
        try {
            return JWT.decode(token);
        } catch (JWTDecodeException exception){
            return null;
        }
    }
}
