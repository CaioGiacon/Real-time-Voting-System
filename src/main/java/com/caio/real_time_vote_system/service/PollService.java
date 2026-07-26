package com.caio.real_time_vote_system.service;

import com.caio.real_time_vote_system.dtos.PollDTO;
import com.caio.real_time_vote_system.infraestructure.entity.Poll;
import com.caio.real_time_vote_system.infraestructure.entity.User;
import com.caio.real_time_vote_system.infraestructure.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;
    private final UserService userService;

    public Poll createPoll(Long userId, PollDTO pollDTO) {
        Poll poll = new Poll();
        poll.setTitle(pollDTO.title());
        poll.setQuestion(pollDTO.questions());
        poll.setStatus(pollDTO.status());
        poll.setEndDate(pollDTO.endDate());

        User user = userService.findUserId(userId);
        poll.setUser(user);

        return pollRepository.save(poll);
    }
}