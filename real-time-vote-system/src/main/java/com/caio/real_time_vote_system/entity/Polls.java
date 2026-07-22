package com.caio.real_time_vote_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "tb_polls")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Polls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 200)
    private String title;
    @Column(name = "question", length = 200)
    private String question;
    @Column(name = "status", length = 9)
    private String status;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column(name = "end_date")
    private LocalDate endDate;


}
