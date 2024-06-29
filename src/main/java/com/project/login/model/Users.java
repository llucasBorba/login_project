package com.project.login.model;

import com.project.login.dto.DtoUser;
import com.project.login.model.enun.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column(nullable = false)
    private UserStatus status;

    public Users(DtoUser dtoUser) {
        BeanUtils.copyProperties(dtoUser,this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
