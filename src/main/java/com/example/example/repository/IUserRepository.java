package com.example.example.repository;

import com.example.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Repository // Crear el bean
public interface IUserRepository extends JpaRepository <Users, Long> {

    /* Agregando otro metodo 'Encontrar por username' */
    @Transactional(readOnly = true) // Solo lectura, no permite la modificacion de datos
    Optional<Users> findByUsername(String username);

}
