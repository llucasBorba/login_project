package com.project.login.model;

import com.project.login.dto.ProfileUserDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "PERFIL_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProfileUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "ID_PROFILE")
    private Profile profile;

    public ProfileUser(ProfileUserDTO profileUserDTO){
        BeanUtils.copyProperties(profileUserDTO,this);
    }



}
