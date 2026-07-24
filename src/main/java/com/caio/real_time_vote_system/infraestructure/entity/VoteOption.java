package com.caio.real_time_vote_system.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_vote_options")
@AllArgsConstructor
@NoArgsConstructor
public class VoteOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text", length = 50)
    private String text;
    @Column(name = "votes_quantity")
    private Integer votesQuantity;

    @OneToMany
    @JoinColumn(name = "vote-option-id", referencedColumnName = "id")
    private List<Vote> vote;

}