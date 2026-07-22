package com.caio.real_time_vote_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Table(name = "tb_votes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Votes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vote_date")
    private LocalDate voteDate;

    @ManyToOne
    @JoinColumn(name = "polls_id", referencedColumnName = "id")
    private List<Polls> polls;

    @OneToMany
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private List<VoteOptions> voteOptions;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Users> users;
}
