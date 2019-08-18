package com.oocl.tdd.eenum;

public enum Num {
    TWO(2), THERE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NIGHT(9), TEN(10),Jack(11), QUEEN(12),
    KING(13), ACE(14);
    private int value;

    Num(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
