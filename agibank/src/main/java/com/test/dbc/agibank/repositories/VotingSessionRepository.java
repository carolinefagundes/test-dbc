package com.test.dbc.agibank.repositories;

import com.test.dbc.agibank.models.VotingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingSessionRepository extends JpaRepository<VotingSession, String> {

    VotingSession findByUuid (String uuid);

}
