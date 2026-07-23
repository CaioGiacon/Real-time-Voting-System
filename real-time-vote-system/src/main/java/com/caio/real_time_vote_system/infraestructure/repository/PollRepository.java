package com.caio.real_time_vote_system.infraestructure.repository;

import com.caio.real_time_vote_system.infraestructure.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
