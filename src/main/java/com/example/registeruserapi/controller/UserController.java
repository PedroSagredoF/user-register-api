package com.example.registeruserapi.controller;

import com.example.registeruserapi.Service.UserService;
import com.example.registeruserapi.domain.UserRequest;
import com.example.registeruserapi.entity.User;
import com.example.registeruserapi.exception.ErrorException;
import com.example.registeruserapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> registro(@RequestBody UserRequest request) throws ErrorException {

        try {
            emailValidation(request);
            passwordValidation(request);
            return new ResponseEntity<Object>(userService.register(request), HttpStatus.CREATED);
        } catch (ErrorException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatusCode.valueOf(e.getStatusCode()));
        }

    }

    private void passwordValidation(UserRequest request) {
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{7}$");
        String pass = request.getPassword();
        if (!pattern.matcher(pass).matches())
            throw new ErrorException("Formato de contraseña Incorrecto", 400);

    }

    private void emailValidation(UserRequest request) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        String email = request.getEmail();
        if (email != null) email = request.getEmail().toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new ErrorException("Formato de correo Incorrecto", 400);

        User userValid = userRepository.findEmail(request.getEmail());
        if (userValid != null) throw new ErrorException("El correo ya registrado", 400);

    }
}
