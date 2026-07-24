package com.caio.real_time_vote_system.service;

import com.caio.real_time_vote_system.infraestructure.entity.User;
import com.caio.real_time_vote_system.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }


}
