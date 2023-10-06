package com.test.dbc.agibank.models;

import com.test.dbc.agibank.enums.VoteType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vote {

    private AccountHolder accountHolder;

    private VoteType voteType;

}
