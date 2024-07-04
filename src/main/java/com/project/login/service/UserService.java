package com.project.login.service;

import com.project.login.dto.UserDTO;
import com.project.login.model.Users;
import com.project.login.model.enun.UserStatus;
import com.project.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  Cryptographic cryptographic;

    public List<UserDTO> getAllUsers(){
        List<Users> usuarios = userRepository.findAll();
        return usuarios.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO getUserByEmail(String email){
        Users user = userRepository.findByEmail(email);
        return new UserDTO(user);
    }
    public UserDTO findById(Long id){
        return new UserDTO(userRepository.findById(id).get());
    }
    public UserDTO post (UserDTO userDTO){
        userDTO.setStatus(UserStatus.INATIVO);
        String rawPassword = userDTO.getPassword();
        Users user = new Users(userDTO);
        user.setPassword(cryptographic.encriptarSenha(rawPassword));
        return new UserDTO(userRepository.save(user));
    }

    public void delete (Long id){
        userRepository.deleteById(id);
    }

    public UserDTO update(UserDTO userDTO){
        Users user = new Users(userDTO);
        return new UserDTO(userRepository.save(user));
    }

}
