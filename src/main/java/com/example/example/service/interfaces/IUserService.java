package com.example.example.service.interfaces;

import com.example.example.dto.UserRequest;
import com.example.example.dto.UsersDTO;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public interface IUserService {

    List<UsersDTO> findAll();

    UsersDTO findByUsername(String username);

    UsersDTO findById(int userId);

    void save(UserRequest user);

    void update(UserRequest user, int userId);

    void saveAll(List<UserRequest> user);

    void deleteById(int userId);

}
