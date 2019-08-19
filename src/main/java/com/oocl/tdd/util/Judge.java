package com.oocl.tdd.util;

import com.oocl.tdd.entity.Card;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Judge {
    public static boolean isStraightFlush(List<Card> cardList){
        return isStraight(cardList) && isFlush(cardList);
    }

    public static boolean isFourOfAKind(List<Card> cardList){
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 4);
    }


    public static boolean isFullHouse(List<Card> cardList) {
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 3) &&
                cardList.stream()
                        .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                        .entrySet().stream()
                        .anyMatch(entry -> entry.getValue() == 2);
    }

    public static boolean isFlush(List<Card> cardList) {
        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getColor().getType(), item -> 1, Integer::sum))
                .entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 5);
    }

    public static boolean isStraight(List<Card> cardList) {
        for (int i = 1; i < cardList.size(); i++) {
            if (cardList.get(i).getNumber().getValue() != (cardList.get(i - 1).getNumber().getValue() + 1)) {
                return false;
            }
        }
        return true;
    }

    public static Map getCardListLevel(List<Card> cardList) {

        return cardList.stream()
                .collect(Collectors.toMap(item -> item.getNumber().getValue(), item -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
    }
}
