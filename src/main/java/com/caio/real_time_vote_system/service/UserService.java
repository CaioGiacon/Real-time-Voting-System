package com.caio.real_time_vote_system.service;

import com.caio.real_time_vote_system.dtos.UserDTO;
import com.caio.real_time_vote_system.infraestructure.entity.User;
import com.caio.real_time_vote_system.infraestructure.exception.EmailAlreadyExistException;
import com.caio.real_time_vote_system.infraestructure.exception.IdUserNotFoundException;
import com.caio.real_time_vote_system.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        try{
            User user = new User();
            user.setName(userDTO.name());
            emailExist(userDTO.email());
            user.setEmail(userDTO.email());

            return userRepository.save(user);
        }catch(EmailAlreadyExistException e) {
            throw new EmailAlreadyExistException("Email already taken", e.getCause());
        }

    }

    public boolean doesEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public void emailExist(String email) {
        try{
            boolean emailExist = doesEmailExist(email);
            if(emailExist) {
                throw new EmailAlreadyExistException("Email already taken" + email);
            }
        } catch (EmailAlreadyExistException e) {
            throw new EmailAlreadyExistException("Email already taken", e.getCause());
        }
    }

    public User findUserId(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IdUserNotFoundException("Id not found " + id));
    }
}