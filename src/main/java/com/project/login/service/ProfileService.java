package com.project.login.service;

import com.project.login.dto.ProfileDTO;
import com.project.login.model.Profile;
import com.project.login.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileDTO> getAllProfiles(){
        List<Profile> profiles = profileRepository.findAll();
        return profiles.stream().map(ProfileDTO::new).collect(Collectors.toList());
    }

    public ProfileDTO getProfileById(Long id){
        return new ProfileDTO(profileRepository.findById(id).get());
    }

    public ProfileDTO createProfile(ProfileDTO profileDTO){
        Profile profile = new Profile(profileDTO);
        return new ProfileDTO(profileRepository.save(profile));
    }

    public ProfileDTO put(ProfileDTO profileDTO){
        Profile profile = new Profile(profileDTO);
        return new ProfileDTO(profileRepository.save(profile));
    }

    public void deleteProfile(Long id){
        profileRepository.deleteById(id);
    }
}
