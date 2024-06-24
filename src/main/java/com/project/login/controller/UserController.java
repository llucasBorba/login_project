package com.project.login.controller;

import com.project.login.model.Users;
import com.project.login.service.Cryptographic;
import com.project.login.service.EmailService;
import com.project.login.dto.DtoUser;
import com.project.login.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserRepository userRepository;
    private final Cryptographic cryptographic;
    private final EmailService emailService;


    public UserController(UserRepository userRepository, Cryptographic cryptographic, EmailService emailService) {
        this.userRepository = userRepository;
        this.cryptographic = cryptographic;
        this.emailService = emailService;
    }

    @PostMapping(" ")
    public ResponseEntity<Object> creatUser(@RequestBody DtoUser dtoUser){
        if (dtoUser.getEmail() == null || dtoUser.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body("Email é obrigatorio");
        }
//        if (userRepository.findByEmail(dtoUser.email()) != null) {
//            return ResponseEntity.badRequest().body("Email já cadastrado");
//        }
        String hashPassword = cryptographic.encriptarSenha(dtoUser.getPassword());
        Users user = new Users(dtoUser);
        user.setPassword(hashPassword);
        Users savedUser = userRepository.save(user);
        String message = emailService.sendTextMail(user.getEmail(),"Token de validação", "6575");
        return ResponseEntity.ok(savedUser);
    }



}
