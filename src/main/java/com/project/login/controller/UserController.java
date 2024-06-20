package com.project.login.controller;

import com.project.login.Model.Users;
import com.project.login.Service.Cryptographic;
import com.project.login.Service.EmailService;
import com.project.login.Service.SaltGenerator;
import com.project.login.dto.DtoUser;
import com.project.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (dtoUser.email() == null || dtoUser.email().isEmpty()){
            return ResponseEntity.badRequest().body("Email é obrigatorio");
        }
//        if (userRepository.findByEmail(dtoUser.email()) != null) {
//            return ResponseEntity.badRequest().body("Email já cadastrado");
//        }
        String salt = SaltGenerator.gerarSalt();
        String hashPassword = cryptographic.encriptarSenha(dtoUser.password(), salt);
        Users user = new Users(dtoUser.email(),hashPassword,salt);
        Users savedUser = userRepository.save(user);

        String message = emailService.sendTextMail(user.getEmail(),"Deixa de ser baitola", "GAYYYYY");


        return ResponseEntity.ok(savedUser + message);
    }

}
