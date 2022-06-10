package com.atlantis.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;


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
    public boolean tokenValidate(String token) // Token'ın valid olup olmadığını doğrulamak için metodumuzu oluştururuz.
    {
        if (getUsernameToken(token) != null && isExpired(token) ) {
            return true;
        }
            return false;

    }
    public String getUsernameToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public boolean isExpired(String token){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
