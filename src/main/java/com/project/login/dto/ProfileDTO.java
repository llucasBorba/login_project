package com.project.login.dto;

import com.project.login.model.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    private Long id; 
    private String descricao;

    public ProfileDTO(Profile profile){
        BeanUtils.copyProperties(profile,this);
    }
}
