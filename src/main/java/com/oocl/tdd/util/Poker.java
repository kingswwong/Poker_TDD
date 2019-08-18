package com.oocl.tdd.util;

import com.oocl.tdd.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class Poker {

    public String judgeWhoWin(List<Card> onePlayerCardList, List<Card> twoPlayerCardList) {
        onePlayerCardList.sort(Card::compareTo);
        twoPlayerCardList.sort(Card::compareTo);

        for(int i = onePlayerCardList.size() - 1;i >= 0;i--){
            if(onePlayerCardList.get(i).getNumber().getValue() > twoPlayerCardList.get(i).getNumber().getValue()){
                return "1";
            }else if(onePlayerCardList.get(i).getNumber().getValue() < twoPlayerCardList.get(i).getNumber().getValue()){
                return "2";
            }
        }
        return "draw";
    }
}
