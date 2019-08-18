package com.oocl.tdd.entity;

import org.junit.Test;

import java.security.KeyStore;
import java.util.ArrayList;

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

    @Test
    public void should_return_list_length_is_5_when_given_cardInfo_string_is_2H3D5S9CKD() {
        ArrayList<Card> cardList = Card.generateCard("2H3D5S9CKD");
        assertEquals(5, cardList.size());
        assertEquals(2,cardList.get(0).getNumber().getValue());
        assertEquals(13,cardList.get(4).getNumber().getValue());
        assertEquals("D",cardList.get(4).getColor().getType());
    }
}