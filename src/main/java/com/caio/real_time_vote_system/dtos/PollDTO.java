package com.caio.real_time_vote_system.dtos;

import java.time.LocalDate;
import java.util.List;

public record PollDTO(String title, List<String> questions, String status,
                      LocalDate creationDate, LocalDate endDate, Long userId) {
}
