package com.oocl.tdd.eenum;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Num {
    TWO(2), THERE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NIGHT(9), T(10),J(11), Q(12),
    K(13), A(14);
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

    public static Num getNumByValue(int value){
        return Arrays.asList(Num.values()).stream().filter(item -> item.getValue() == value).findFirst().get();
    }
}
