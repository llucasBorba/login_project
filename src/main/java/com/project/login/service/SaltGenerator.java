package com.project.login.service;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class SaltGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String gerarSalt() {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().encodeToString(bytes);
    }
    

}
