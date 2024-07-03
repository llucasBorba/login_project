package com.project.login.dto;

import com.project.login.model.ProfileUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProfileUserDTO {

    private Long id;
    private UserDTO userDTO;
    private ProfileDTO profileDTO;

    public ProfileUserDTO(ProfileUser profileUser){
        BeanUtils.copyProperties(profileUser,this);
        if(profileUser.getProfile() != null){
            this.userDTO = new UserDTO(profileUser.getUsers());
        }
        if(profileUser.getProfile() != null){
            this.profileDTO = new ProfileDTO(profileUser.getProfile());
        }

    }

}
