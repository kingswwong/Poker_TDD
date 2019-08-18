package com.oocl.tdd.eenum;

public enum Color {
    C("C"), D("D"), H("H"), S("S");
    private String type;

    Color(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
