package com.oocl.tdd.entity;

import com.oocl.tdd.eenum.Color;
import com.oocl.tdd.eenum.Num;

import java.util.ArrayList;

public class Card {

    private Color color;
    private Num number;

    public Card(Color color, Num number) {
        this.color = color;
        this.number = number;
    }

    public Card(String cardInfo) {
        if(Character.isDigit(cardInfo.charAt(0))){
            this.number = Num.getNumByValue(Integer.parseInt(cardInfo.charAt(0) + ""));
        }else{
            this.number = Num.valueOf(cardInfo.charAt(0) + "");
        }
        this.color = Color.valueOf(cardInfo.charAt(1) + "");
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Num getNumber() {
        return number;
    }

    public void setNumber(Num number) {
        this.number = number;
    }

    public static ArrayList<Card> generateCard(String cardNums){
        ArrayList<Card> cardList = new ArrayList<Card>();
        for(int i = 0;i < cardNums.length();i+=2){
            String cardInfo = cardNums.substring(i, i + 2);
            cardList.add(new Card(cardInfo));
        }
        return cardList;
    }
}
