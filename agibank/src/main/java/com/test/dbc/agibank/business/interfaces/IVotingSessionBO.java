package com.test.dbc.agibank.business.interfaces;

import com.test.dbc.agibank.models.Vote;
import com.test.dbc.agibank.models.VotingSession;

public interface IVotingSessionBO {

    VotingSession openSession(String scheduleUuid, VotingSession votingSession);

    boolean receiveVote(String sessionUuid, Vote vote);

}
