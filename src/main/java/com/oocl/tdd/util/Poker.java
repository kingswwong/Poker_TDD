package com.oocl.tdd.util;

import com.oocl.tdd.entity.Card;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.oocl.tdd.util.Judge.*;

public class Poker {


    public String judgeWhoWin(List<Card> onePlayerCardList, List<Card> twoPlayerCardList) {
        onePlayerCardList.sort(Card::compareTo);
        twoPlayerCardList.sort(Card::compareTo);
        if(isStraightFlush(onePlayerCardList) != isStraightFlush(twoPlayerCardList)){
            return isStraightFlush(onePlayerCardList) ? "1" : "2";
        }
        if (isFourOfAKind(onePlayerCardList) != isFourOfAKind(twoPlayerCardList)) {
            return isFourOfAKind(onePlayerCardList) ? "1" : "2";
        }
        if (isFullHouse(onePlayerCardList) != isFullHouse(twoPlayerCardList)) {
            return isFullHouse(onePlayerCardList) ? "1" : "2";
        }
        if (isFlush(onePlayerCardList) != isFlush(twoPlayerCardList)) {
            return isFlush(onePlayerCardList) ? "1" : "2";
        }
        if (isStraight(onePlayerCardList) != isStraight(twoPlayerCardList)) {
            return isStraight(onePlayerCardList) ? "1" : "2";
        }
        Map<Integer, Integer> onePlayerCardListMap = getCardListLevel(onePlayerCardList);
        Map<Integer, Integer> twoPlayerCardListMap = getCardListLevel(twoPlayerCardList);
        int onePlayerCardMaxLevel = 0;
        int twoPlayerCardMaxLevel = 0;
        for (Integer key1 : onePlayerCardListMap.keySet()) {
            if (onePlayerCardListMap.get(key1) > onePlayerCardMaxLevel) {
                onePlayerCardMaxLevel = onePlayerCardListMap.get(key1);
            }
        }
        for (Integer key2 : twoPlayerCardListMap.keySet()) {
            if (twoPlayerCardListMap.get(key2) > twoPlayerCardMaxLevel) {
                twoPlayerCardMaxLevel = twoPlayerCardListMap.get(key2);
            }
        }
        if (onePlayerCardMaxLevel != twoPlayerCardMaxLevel) {
            return onePlayerCardMaxLevel > twoPlayerCardMaxLevel ? "1" : "2";
        }
        for (Integer key1 : onePlayerCardListMap.keySet()) {
            int value1 = onePlayerCardListMap.get(key1);
            for (Integer key2 : twoPlayerCardListMap.keySet()) {
                if (twoPlayerCardListMap.get(key2) == value1) {
                    if (key1 != key2) {
                        return key1 > key2 ? "1" : "2";
                    }
                }
            }
        }
        for (int i = onePlayerCardList.size() - 1; i >= 0; i--) {
            if (onePlayerCardList.get(i).getNumber().getValue() != twoPlayerCardList.get(i).getNumber().getValue()) {
                return onePlayerCardList.get(i).getNumber().getValue() > twoPlayerCardList.get(i).getNumber().getValue() ? "1" : "2";
            }
        }
        return "draw";
    }
}
