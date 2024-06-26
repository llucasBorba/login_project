package com.project.login.service;

import com.project.login.dto.DtoUser;
import com.project.login.model.Users;
import com.project.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<DtoUser> getAllUsers(){
        List<Users> usuarios = userRepository.findAll();
        return usuarios.stream().map(DtoUser::new).collect(Collectors.toList());
    }

    public DtoUser getUserByEmail(String email){
        Users user = userRepository.findByEmail(email);
        return new DtoUser(user);
    }
    public DtoUser findById(String id){
        UUID uuid = UUID.fromString(id);
        return new DtoUser(userRepository.findById(uuid).get());
    }



    public DtoUser post (DtoUser dtoUser){
        Users user = new Users(dtoUser);
        return new DtoUser(userRepository.save(user));
    }

    public void delete (UUID id){
        userRepository.deleteById(id);
    }

    public DtoUser update(DtoUser dtoUser){
        Users user = new Users(dtoUser);
        return new DtoUser(userRepository.save(user));
    }



}
