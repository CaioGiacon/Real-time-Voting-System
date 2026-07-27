package com.caio.real_time_vote_system.controller;

import com.caio.real_time_vote_system.dtos.PollDTO;
import com.caio.real_time_vote_system.infraestructure.entity.Poll;
import com.caio.real_time_vote_system.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votesystem")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

   @PostMapping("users/{id}/polls")
   public ResponseEntity<PollDTO> savePoll(@PathVariable Long id, @RequestBody PollDTO pollDTO) {
        Poll newPoll = pollService.createPoll(id, pollDTO);

        PollDTO pollResponseDTO = new PollDTO(
                newPoll.getId(),
                newPoll.getTitle(),
                newPoll.getQuestion(),
                newPoll.getStatus(),
                newPoll.getCreationDate(),
                newPoll.getEndDate(),
                newPoll.getUser().getId()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(pollResponseDTO);
    }
}