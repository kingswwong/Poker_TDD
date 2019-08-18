package com.oocl.tdd.entity;

import com.oocl.tdd.eenum.Color;
import com.oocl.tdd.eenum.Num;

public class Card {

    private Color color;
    private Num number;

    public Card(Color color, Num number) {
        this.color = color;
        this.number = number;
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

    public Card generateCard(String card){
        return null;
    }

}
