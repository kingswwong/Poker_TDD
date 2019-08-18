package com.oocl.tdd.util;

import com.oocl.tdd.entity.Card;

public class Poker {

    public String judgeWhoWin(Card onePlayerCard, Card twoPlayerCard) {

        if(onePlayerCard.getNumber().getValue() == twoPlayerCard.getNumber().getValue()){
            return "draw";
        }
        return onePlayerCard.getNumber().getValue() > twoPlayerCard.getNumber().getValue() ? "1" : "2";
    }
}
