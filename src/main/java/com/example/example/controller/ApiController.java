package com.example.example.controller;

import com.example.example.dto.UserRequest;
import com.example.example.service.interfaces.IUserService;
import com.example.example.utilis.Exceptions.ApiUnprocessableEntity422;
import com.example.example.validator.UserValidatorImpl;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // Permite conexiones desde diferentes puntos
@RequestMapping("/users")
public class ApiController {

    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;
    @Autowired
    private UserValidatorImpl userValidator;

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping(value="/by/{username}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(this.userService.findByUsername(username));
    }

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) throws ApiUnprocessableEntity422 {
        this.userService.save(request);
        this.userValidator.validator(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/delete/{userId}" )
    public ResponseEntity<Object> deleteUser(@PathVariable int userId){
        this.userService.deleteById(userId);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<Object> updateUser(@RequestBody UserRequest request, @PathVariable int userId){
        this.userService.update(request, userId);
        return ResponseEntity.ok(Boolean.TRUE);
    }


}
