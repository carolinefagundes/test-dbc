package com.test.dbc.agibank.controller;

import com.test.dbc.agibank.business.interfaces.IVotingSessionBO;
import com.test.dbc.agibank.models.Vote;
import com.test.dbc.agibank.models.VotingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/voting-session")
public class VotingSessionController {

    @Autowired
    private IVotingSessionBO votingSessionBO;

    @PostMapping("/{scheduleUuid}/session")
    public VotingSession openSession(@PathVariable String scheduleUuid, @RequestBody VotingSession votingSession) {
        return votingSessionBO.openSession(scheduleUuid, votingSession);
    }

    @PostMapping("/{sessionUuid}/vote")
    public ResponseEntity<Boolean> receiveVote(@PathVariable String sessionUuid, @RequestBody Vote vote) {
        return ResponseEntity.ok(votingSessionBO.receiveVote(sessionUuid, vote));
    }


}
