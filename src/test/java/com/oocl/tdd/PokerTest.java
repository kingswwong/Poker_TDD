package com.oocl.tdd;

import com.oocl.tdd.entity.Card;
import com.oocl.tdd.util.Poker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PokerTest {

    @Test
    public void should_return_1_when_given_1_player_card_value_is_3D_and_2_player_card_value_is_2D() {
        Card onePlayerCard = new Card("3D");
        Card twoPlayerCard = new Card("2D");

        Poker poker = new Poker();
        assertEquals("1", poker.judgeWhoWin(Arrays.asList(onePlayerCard), Arrays.asList(twoPlayerCard)));
    }

    @Test
    public void should_return_1_when_given_1_player_card_value_is_AH_and_2_player_card_value_is_TD() {
        Card onePlayerCard = new Card("AD");
        Card twoPlayerCard = new Card("TD");

        Poker poker = new Poker();
        assertEquals("1", poker.judgeWhoWin(Arrays.asList(onePlayerCard), Arrays.asList(twoPlayerCard)));
    }

    @Test
    public void should_return_draw_when_given_1_player_card_value_is_TD_and_2_player_card_value_is_TD() {
        Card onePlayerCard = new Card("TD");
        Card twoPlayerCard = new Card("TD");
        Poker poker = new Poker();
        assertEquals("draw", poker.judgeWhoWin(Arrays.asList(onePlayerCard), Arrays.asList(twoPlayerCard)));
    }

    @Test
    public void should_return_1_when_given_1_player_card_value_is_2H3D5S9CKD_and_2_player_card_value_is_3D4S6CTD9D() {

        Poker poker = new Poker();

        ArrayList<Card> onePlayerCardList = Card.generateCard("2H3D5S9CKD");
        ArrayList<Card> twoPlayerCardList = Card.generateCard("3D4S6CTD9D");
        assertEquals("1", poker.judgeWhoWin(onePlayerCardList, twoPlayerCardList));

    }

    @Test
    public void should_return_draw_when_given_1_player_card_value_is_2H3D5S9CKD_and_2_player_card_value_is_2H5S9CKD3S() {

        Poker poker = new Poker();

        ArrayList<Card> onePlayerCardList = Card.generateCard("2H3D5S9CKD");
        ArrayList<Card> twoPlayerCardList = Card.generateCard("3D4S6CTD9D");
        assertEquals("1", poker.judgeWhoWin(onePlayerCardList, twoPlayerCardList));

    }

    @Test
    public void should_return_2_when_given_1_player_card_value_is_2H3D5S9CKD_and_2_player_card_value_is_3D3S6CTD9D() {

        Poker poker = new Poker();

        ArrayList<Card> onePlayerCardList = Card.generateCard("2H3D5S9CKD");
        ArrayList<Card> twoPlayerCardList = Card.generateCard("3D3S6CTD9D");
        assertEquals("2", poker.judgeWhoWin(onePlayerCardList, twoPlayerCardList));

    }

    @Test
    public void should_return_2_when_given_2_player_card_value_is_3H3D5S9CKD_and_2_player_card_value_is_5D5S6CTD9D() {

        Poker poker = new Poker();

        ArrayList<Card> onePlayerCardList = Card.generateCard("3H3D5S9CKD");
        ArrayList<Card> twoPlayerCardList = Card.generateCard("5D5S6CTD9D");
        assertEquals("2", poker.judgeWhoWin(onePlayerCardList, twoPlayerCardList));

    }

    @Test
    public void should_return_1_when_given_1_player_card_value_is_3H3D5S9CKD_and_2_player_card_value_is_3D3S6CTD9D() {

        Poker poker = new Poker();

        ArrayList<Card> onePlayerCardList = Card.generateCard("3H3D5S9CKD");
        ArrayList<Card> twoPlayerCardList = Card.generateCard("3D3S6CTD9D");
        assertEquals("1", poker.judgeWhoWin(onePlayerCardList, twoPlayerCardList));

    }
    
}