package com.example.registeruserapi.Utils;

import com.example.registeruserapi.constants.Constants;
import com.example.registeruserapi.domain.UserRequest;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Date;


public class JWTGenerator {

    public static final long TOKEN_VALIDITY = 2 * 60 * 60 * 1000;

    public static String generateJWTToken(UserRequest request) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constants.API_SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(request.getEmail())
                .setSubject(request.getPassword())
                .signWith(signatureAlgorithm, signingKey);

        long nowMillis = System.currentTimeMillis();
        Date exp = Util.addMinutesToDate(30, new Date(nowMillis));
        builder.setExpiration(exp);
        return builder.compact();
    }
}

