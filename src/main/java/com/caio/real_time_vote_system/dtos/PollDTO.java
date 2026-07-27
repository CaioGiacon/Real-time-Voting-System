package com.caio.real_time_vote_system.dtos;

import java.time.LocalDate;

public record PollDTO(Long id, String title, String questions, String status,
                      LocalDate creationDate, LocalDate endDate, Long userId) {
}
