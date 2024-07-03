package com.project.login.service;

import com.project.login.dto.ProfileUserDTO;
import com.project.login.model.ProfileUser;
import com.project.login.repository.ProfileUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileUserService {

    @Autowired
    private ProfileUserRepository profileUserRepository;

    public List<ProfileUserDTO> getAllProfileUsers(){
        List<ProfileUser> profilesUsers = profileUserRepository.findAll();
        return profilesUsers.stream().map(ProfileUserDTO::new).collect(Collectors.toList());
    }

    public ProfileUserDTO getProfileUserById(Long id){
        return new ProfileUserDTO(profileUserRepository.findById(id).get());
    }

    public ProfileUserDTO createProfileUser(ProfileUserDTO profileUserDTO){
        ProfileUser profileUser = new ProfileUser(profileUserDTO);
        return new ProfileUserDTO(profileUserRepository.save(profileUser));
    }

    public ProfileUserDTO put(ProfileUserDTO profileUserDTO){
        ProfileUser profile = new ProfileUser(profileUserDTO);
        return new ProfileUserDTO(profileUserRepository.save(profile));
    }

    public void deleteProfileUser(Long id){
        profileUserRepository.deleteById(id);
    }
}

