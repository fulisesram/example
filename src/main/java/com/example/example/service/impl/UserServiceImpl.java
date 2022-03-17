package com.example.example.service.impl;

import com.example.example.dto.UserRequest;
import com.example.example.dto.UsersDTO;
import com.example.example.entity.Users;
import com.example.example.repository.IUserRepository;
import com.example.example.service.interfaces.IUserService;
import com.example.example.utilis.Helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.*;

@Component // Para reacion de inyeccion de dependencias
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UsersDTO> findAll() {
        List<UsersDTO> dto = new ArrayList<>();
        Iterable<Users> users = this.userRepository.findAll();
        for (Users user : users){
            UsersDTO usersDTO = MHelpers.modelMapper().map(user, UsersDTO.class);
            dto.add(usersDTO);
        }
        return dto;
    }

    @Override
    public UsersDTO findByUsername(String username) {
        Optional<Users> users = this.userRepository.findByUsername(username);
        if (!users.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map((Object) users.get(), (Type) UsersDTO.class);
    }

    @Override
    public UsersDTO findById(int userId) {
        Optional<Users> users = this.userRepository.findById((long) userId);
        if (!users.isPresent()){
            return null;
        }
        return MHelpers.modelMapper().map((Object) users.get(), (Type) UsersDTO.class);
    }

    @Override
    public void save(UserRequest user) {
        Users users = MHelpers.modelMapper().map(user, Users.class);
        users.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        this.userRepository.save(users);
    }

    @Override
    public void update(UserRequest request, int userId) {
        Optional<Users> users = this.userRepository.findById((long) userId);
        Users user = users.get();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        if(!request.getPassword().isEmpty()){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }
        this.userRepository.save(user);
    }

    @Override
    public void saveAll(List<UserRequest> users) {
        List<Users> u = new ArrayList<>();
        for (UserRequest user : users){
            Users us = MHelpers.modelMapper().map(user, Users.class);
            u.add(us);
        }
        this.userRepository.saveAll(u);
    }

    @Override
    public void deleteById(int userId) {
        this.userRepository.deleteById((long) userId);
    }

    private UsersDTO convertToUserDTO(final Users users){
        return MHelpers.modelMapper().map(users, UsersDTO.class);
    }

}
