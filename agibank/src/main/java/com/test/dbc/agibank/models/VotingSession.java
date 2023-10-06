package com.test.dbc.agibank.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class VotingSession {

    @NotNull
    @Id
    private String uuid = UUID.randomUUID().toString();

    @OneToOne
    @JoinColumn(name = "scheduleUuid")
    private Schedule schedule;

    private Date created = new Date();

    private int durationMinutes = 1;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "vote")
    private List<Vote> voteList = new ArrayList<>();

}
