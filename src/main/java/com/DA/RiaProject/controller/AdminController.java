package com.DA.RiaProject.controller;

import com.DA.RiaProject.entities.User;
import com.DA.RiaProject.entities.UserRole;
import com.DA.RiaProject.entities.UserStatus;
import com.DA.RiaProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> listUsers() {
        return  ResponseEntity.ok(userService.getList());
    }

    @GetMapping(value = "/usersNew")
    public ResponseEntity<?> listNewUsers() {
        return ResponseEntity.ok(userService.getListNew());
    }

    @GetMapping(value = "/usersActive")
    public ResponseEntity<?> listActiveUsers() {
        return ResponseEntity.ok(userService.getListActive());
    }

    @GetMapping(value = "/usersDisabled")
    public ResponseEntity<?> listDisabledUsers() {
        return ResponseEntity.ok(userService.getListDisabled());
    }

    @GetMapping(value = "/details/{id}")
    public ResponseEntity<?> showDetails(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PatchMapping(path = "/updateRole/{id}")
    public ResponseEntity<?> updateUserRole(@PathVariable("id") Integer id, @RequestParam("role") String role) {
        final User user = userService.updateRole(id, UserRole.valueOf(role));
        return ResponseEntity.ok(user);
    }

    @PatchMapping(path = "/updateStatus/{id}")
    public ResponseEntity<?> updateUserStatus(@PathVariable("id") Integer id, @RequestParam("status") String status) {
        final User user = userService.updateStatus(id, UserStatus.valueOf(status));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final int principalId = userService.getUser(principal.getUsername()).getId();
        userService.delete(id);
        if (principalId == id) {
            SecurityContextHolder.clearContext();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } else {
            return ResponseEntity.ok("User deleted");
        }
    }
}