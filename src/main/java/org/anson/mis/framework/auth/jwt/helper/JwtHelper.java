package org.anson.mis.framework.auth.jwt.helper;

import org.anson.mis.framework.auth.jwt.util.JwtUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtHelper {
    private static String issuer;
    private static String subject;
    private static String audience;
    private static String secret;
    private static Integer ttl;
    private static Integer refreshTtl;

    public static String createToken(String userNo){
        String jwtId = UUID.randomUUID().toString();
        Date issuedAt = new Date();
        Date expiresAt = new Date(JwtHelper.ttl * 1000);
        Date refreshExpiresAt = new Date(JwtHelper.refreshTtl * 1000);

        Map<String, Object> claimMap = new HashMap<String, Object>();
        claimMap.put("userNo", userNo);
        claimMap.put("refreshExpiresAt", refreshExpiresAt);

        return JwtUtil.createToken(jwtId, JwtHelper.issuer, JwtHelper.subject, JwtHelper.audience,
                issuedAt, expiresAt, claimMap, JwtHelper.secret);
    }
}
