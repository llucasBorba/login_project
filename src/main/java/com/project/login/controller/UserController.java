package com.project.login.controller;

import com.project.login.service.Cryptographic;
import com.project.login.service.EmailService;
import com.project.login.dto.DtoUser;
import com.project.login.repository.UserRepository;
import com.project.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private  Cryptographic cryptographic;
    @Autowired
    private  UserService userService;


    @PostMapping(" ")
    public ResponseEntity<Object> creatUser(@RequestBody DtoUser dtoUser){
        if (dtoUser.getEmail() == null || dtoUser.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body("Email é obrigatorio");
        }
//        if (userRepository.findByEmail(dtoUser.email()) != null) {
//            return ResponseEntity.badRequest().body("Email já cadastrado");
//        }
        String hashPassword = cryptographic.encriptarSenha(dtoUser.getPassword());
        dtoUser.setPassword(hashPassword);

        //String message = emailService.sendTextMail(user.getEmail(),"Token de validação", "6575");

        return ResponseEntity.ok(userService.post(dtoUser));
    }

    @GetMapping("")
    public ResponseEntity<List<DtoUser>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity<DtoUser> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoUser> getUserByid(@PathVariable String id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(" ")
    public ResponseEntity<DtoUser> updateUser(@RequestBody DtoUser dtoUser){
        return ResponseEntity.ok(userService.update(dtoUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
      userService.delete(id);
      return ResponseEntity.ok(null);
    }







}
