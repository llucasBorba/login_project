package com.project.login.controller;

import com.project.login.dto.UserDTO;
import com.project.login.service.EmailService;
import com.project.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private EmailService emailService;


    @PostMapping(" ")
    public ResponseEntity<Object> creatUser(@RequestBody UserDTO userDTO){
        if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body("Email é obrigatorio");
        }
//        if (userRepository.findByEmail(dtoUser.email()) != null) {
//            return ResponseEntity.badRequest().body("Email já cadastrado");
//        }

// String message = emailService.sendTextMail(dtoUser.getEmail(),"Você tem perfil foda ", "6575");

        return ResponseEntity.ok(userService.post(userDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByid(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(" ")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.update(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
      userService.delete(id);
      return ResponseEntity.ok(null);
    }
}
