package com.project.login.controller;

import com.project.login.dto.ProfileUserDTO;
import com.project.login.service.ProfileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Profile-User")
@CrossOrigin
public class ProfileUserController {

    @Autowired
     public ProfileUserService profileUserService;

    @GetMapping
    public ResponseEntity<List<ProfileUserDTO>> getAllProfileUser(){
        return ResponseEntity.ok().body(profileUserService.getAllProfileUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileUserDTO> getProfileUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(profileUserService.getProfileUserById(id));
    }

    @PostMapping
    public ResponseEntity<ProfileUserDTO> postProfileUser(@RequestBody ProfileUserDTO profileUserDTO){
        return ResponseEntity.ok().body(profileUserService.createProfileUser(profileUserDTO));
    }

    @PutMapping
    public ResponseEntity<ProfileUserDTO> putProfileUser(@RequestBody ProfileUserDTO profileUserDTO){
        return ResponseEntity.ok().body(profileUserService.put(profileUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        profileUserService.deleteProfileUser(id);
        return ResponseEntity.ok(null);
    }

}
