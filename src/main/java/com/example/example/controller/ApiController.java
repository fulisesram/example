package com.example.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // Permite conexiones desde diferentes puntos
@RequestMapping("/")
public class ApiController {

    @GetMapping("index")
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok("ok");
    }

}
