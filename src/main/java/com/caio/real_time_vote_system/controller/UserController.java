package com.caio.real_time_vote_system.controller;

import com.caio.real_time_vote_system.infraestructure.entity.User;
import com.caio.real_time_vote_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votesystem")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

}