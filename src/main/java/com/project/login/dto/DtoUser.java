package com.project.login.dto;

import com.project.login.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {

    private String email;
    private String password;
    private UUID id;

    public DtoUser(Users user) {
       this.email = user.getEmail();
       this.password = user.getPassword();
       this.id = user.getId();
    }
}
