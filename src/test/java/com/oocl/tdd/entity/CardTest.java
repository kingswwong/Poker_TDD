package com.oocl.tdd.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void should_return_card_with_Color_COLORD_and_NUMTEN_when_given_TD() {
        Card card = new Card("TD");
        assertEquals(10, card.getNumber().getValue());
        assertEquals("D", card.getColor().getType());
    }

    @Test
    public void should_return_card_with_Color_COLORD_and_NUMTWO_when_given_2D() {
        Card card = new Card("2D");
        assertEquals(2, card.getNumber().getValue());
        assertEquals("D", card.getColor().getType());
    }
}