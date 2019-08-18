package com.oocl.tdd.util;

import com.oocl.tdd.entity.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {

    public int getCardListLevel(List<Card> cardList){

        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1,Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList()).size();
    }

    public String judgeWhoWin(List<Card> onePlayerCardList, List<Card> twoPlayerCardList) {
        onePlayerCardList.sort(Card::compareTo);
        twoPlayerCardList.sort(Card::compareTo);
        if(getCardListLevel(onePlayerCardList) != getCardListLevel(twoPlayerCardList)){
            return getCardListLevel(onePlayerCardList) > getCardListLevel(twoPlayerCardList) ? "1" : "2";
        }
        for(int i = onePlayerCardList.size() - 1;i >= 0;i--){
            if(onePlayerCardList.get(i).getNumber().getValue() != twoPlayerCardList.get(i).getNumber().getValue()){
                return onePlayerCardList.get(i).getNumber().getValue() > twoPlayerCardList.get(i).getNumber().getValue() ? "1" : "2";
            }
        }
        return "draw";
    }
}
