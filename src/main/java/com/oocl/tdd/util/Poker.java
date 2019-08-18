package com.oocl.tdd.util;

import com.oocl.tdd.entity.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Poker {

    public Stream<Map.Entry<Integer, Integer>> getCardListNumberStream(List<Card> cardList){
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream();
    }

    public Stream<Map.Entry<String, Integer>> getCardListColorStream(List<Card> cardList){
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getColor().getType(), item -> 1, Integer::sum))
                .entrySet().stream();
    }

    public boolean isStraightFlush(List<Card> cardList){
        return isStraight(cardList) && isFlush(getCardListColorStream(cardList));
    }

    public boolean isFourOfAKind(Stream<Map.Entry<Integer, Integer>> cardNumberStream){
        return cardNumberStream
                .anyMatch(entry -> entry.getValue() == 4);
    }


    public boolean isFullHouse(Stream<Map.Entry<Integer, Integer>> cardNumberStream) {
        return cardNumberStream
                .anyMatch(entry -> entry.getValue() == 3) &&
                cardNumberStream
                        .anyMatch(entry -> entry.getValue() == 2);
    }

    public boolean isFlush(Stream<Map.Entry<String, Integer>> cardNumberStream) {
        return cardNumberStream
                .anyMatch(entry -> entry.getValue() == 5);
    }

    public boolean isStraight(List<Card> cardList) {
        for (int i = 1; i < cardList.size(); i++) {
            if (cardList.get(i).getNumber().getValue() != (cardList.get(i - 1).getNumber().getValue() + 1)) {
                return false;
            }
        }
        return true;
    }

    public Map getCardListLevel(Stream<Map.Entry<Integer, Integer>> cardNumberStream) {

        return cardNumberStream
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
    }

    public String judgeWhoWin(List<Card> onePlayerCardList, List<Card> twoPlayerCardList) {
        onePlayerCardList.sort(Card::compareTo);
        twoPlayerCardList.sort(Card::compareTo);
        Stream<Map.Entry<Integer, Integer>> onePlayerCardNumberStream = getCardListNumberStream(onePlayerCardList);
        Stream<Map.Entry<Integer, Integer>> twoPlayerCardNumberStream= getCardListNumberStream(twoPlayerCardList);
        Stream<Map.Entry<String, Integer>> onePlayerCardColorStream= getCardListColorStream(twoPlayerCardList);
        Stream<Map.Entry<String, Integer>> twoPlayerCardColorStream= getCardListColorStream(twoPlayerCardList);
        if(isStraightFlush(onePlayerCardList) != isStraightFlush(twoPlayerCardList)){
            return isStraightFlush(onePlayerCardList) ? "1" : "2";
        }
        if (isFourOfAKind(onePlayerCardNumberStream) != isFourOfAKind(twoPlayerCardNumberStream)) {
            return isFourOfAKind(twoPlayerCardNumberStream) ? "1" : "2";
        }
        if (isFullHouse(onePlayerCardNumberStream) != isFullHouse(twoPlayerCardNumberStream)) {
            return isFullHouse(onePlayerCardNumberStream) ? "1" : "2";
        }
        if (isFlush(onePlayerCardColorStream) != isFlush(twoPlayerCardColorStream)) {
            return isFlush(onePlayerCardColorStream) ? "1" : "2";
        }
        if (isStraight(onePlayerCardList) != isStraight(twoPlayerCardList)) {
            return isStraight(onePlayerCardList) ? "1" : "2";
        }
        Map<Integer, Integer> onePlayerCardListMap = getCardListLevel(onePlayerCardNumberStream);
        Map<Integer, Integer> twoPlayerCardListMap = getCardListLevel(twoPlayerCardNumberStream);
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
