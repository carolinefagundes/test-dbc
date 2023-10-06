package com.test.dbc.agibank.business;

import com.test.dbc.agibank.business.interfaces.IScheduleBO;
import com.test.dbc.agibank.business.interfaces.IVotingSessionBO;
import com.test.dbc.agibank.models.Schedule;
import com.test.dbc.agibank.models.Vote;
import com.test.dbc.agibank.models.VotingSession;
import com.test.dbc.agibank.repositories.VotingSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Primary
@Service
@Slf4j
public class VotingSessionBO implements IVotingSessionBO {

    @Autowired
    private IScheduleBO scheduleBO;

    @Autowired
    private VotingSessionRepository votingSessionRepository;

    @Override
    public VotingSession openSession(String scheduleUuid, VotingSession votingSession){
        Schedule schedule = scheduleBO.findByUuid(scheduleUuid);
        if (schedule != null) {
            votingSession.setSchedule(schedule);
            return votingSessionRepository.save(votingSession);
        }
        throw new RuntimeException("Schedule not found");
    }

    @Override
    public boolean receiveVote(String sessionUuid, Vote vote){
        VotingSession votingSession = votingSessionRepository.findByUuid(sessionUuid);
        if (votingSession != null) {
            String accountHolder = vote.getAccountHolder().getUuid();
            if (!votingSession.getVoteList().stream().filter(v -> v.getAccountHolder().getUuid().equals(vote.getAccountHolder().getUuid())).findFirst().isPresent()) {
                votingSession.getVoteList().add(vote);
            } else {
                throw new RuntimeException("Associado já votou nesta pauta");
            }
        } else {
            throw new RuntimeException("Sessão de votação não encontrada");
        }
        return true;
    }

}
