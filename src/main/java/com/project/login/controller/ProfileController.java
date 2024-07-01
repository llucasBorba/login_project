package com.project.login.controller;

import com.project.login.dto.ProfileDTO;
import com.project.login.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Profile")
@RestController
@CrossOrigin
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileDTO>> getAllProfiles(){
        return ResponseEntity.ok().body(profileService.getAllProfiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable Long id){
        return ResponseEntity.ok().body(profileService.getProfileById(id));
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> postProfile(@RequestBody ProfileDTO profileDTO){
        return ResponseEntity.ok().body(profileService.createProfile(profileDTO));
    }

    @PutMapping
    public ResponseEntity<ProfileDTO> putResource(@RequestBody ProfileDTO profileDTO){
        return ResponseEntity.ok().body(profileService.put(profileDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        profileService.deleteProfile(id);
        return ResponseEntity.ok(null);
    }
}
