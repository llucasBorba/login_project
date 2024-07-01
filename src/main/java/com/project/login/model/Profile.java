package com.project.login.model;

import com.project.login.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "PROFILE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;
    
    public Profile(ProfileDTO profileDTO){
    BeanUtils.copyProperties(profileDTO,this);}
}
