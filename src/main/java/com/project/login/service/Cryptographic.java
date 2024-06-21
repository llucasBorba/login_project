package com.project.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Cryptographic {

    @Autowired
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String encriptarSenha (String senha, String salt){
        return passwordEncoder.encode(senha + salt);
    }

    public Boolean varificarSenhas (String rawPassword, String cryptPassword){
        return passwordEncoder.matches(rawPassword,cryptPassword);
    }

}
