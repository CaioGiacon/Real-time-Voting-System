package com.caio.real_time_vote_system.service;

import com.caio.real_time_vote_system.infraestructure.entity.User;
import com.caio.real_time_vote_system.infraestructure.exception.EmailAlreadyExistException;
import com.caio.real_time_vote_system.infraestructure.exception.EmailNotFoundException;
import com.caio.real_time_vote_system.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User createUser(User user) {
        try{
            emailExist(user.getEmail());
            return userRepository.save(user);
        }catch(EmailAlreadyExistException e) {
            throw new EmailAlreadyExistException("Email already taken", e.getCause());
        }

    }

    public boolean doesEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public User searchEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new EmailNotFoundException("Email not found " + email));
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
}
