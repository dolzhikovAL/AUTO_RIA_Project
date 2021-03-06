package com.DA.RiaProject.controller;

import com.DA.RiaProject.entities.User;
import com.DA.RiaProject.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class    RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @PostMapping(path = "/registration")
    public ResponseEntity<?> userRegistration(@RequestBody User jsonUser) {
        userService.create(jsonUser);
        return ResponseEntity.ok("User created");
    }
}
