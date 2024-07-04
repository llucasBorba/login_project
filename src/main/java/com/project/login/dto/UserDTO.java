package com.project.login.dto;

import com.project.login.model.Users;
import com.project.login.model.enun.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String email;
    private String password;
    private Long id;
    private UserStatus status;

    public UserDTO(Users user) {
        BeanUtils.copyProperties(user,this);
    }
}
