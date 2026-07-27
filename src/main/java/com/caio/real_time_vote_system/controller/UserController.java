package com.caio.real_time_vote_system.controller;

import com.caio.real_time_vote_system.dtos.UserDTO;
import com.caio.real_time_vote_system.infraestructure.entity.User;
import com.caio.real_time_vote_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votesystem")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        User newUser = userService.createUser(userDTO);

        UserDTO userResponseDTO = new UserDTO(
                newUser.getName(),
                newUser.getEmail()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }
}