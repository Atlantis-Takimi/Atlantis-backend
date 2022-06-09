package com.atlantis.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;


@Service
public class TokenManager {
    private static final String secretKey = "Atlantis2323";
    private static final int validity = 5 * 60 * 1000 ; // İmzalandıktan 5 dk sonraya kadar geçerli olduğunu varsayarsak..
    public String generateToken(String username){
        return Jwts.builder().
                setSubject(username).
                setExpiration(new Date(System.currentTimeMillis() + validity)). // Ne zamana kadar geçerli?
                setIssuer("Admin1"). //Kim İmzaladı,kim yarattı
                setIssuedAt(new Date(System.currentTimeMillis())). // hangi tarihte oluşturuldu(OLuşturulan an imzalandı)
                signWith(SignatureAlgorithm.ES256, secretKey).
                compact();
    }
    public boolean tokenValidate(String token){

    }
    public String getUserFromToken(String token){
    }
}
