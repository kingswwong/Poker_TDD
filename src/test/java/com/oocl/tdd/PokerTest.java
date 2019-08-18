package com.oocl.tdd;

import com.oocl.tdd.eenum.Color;
import com.oocl.tdd.eenum.Num;
import com.oocl.tdd.entity.Card;
import com.oocl.tdd.util.Poker;
import org.junit.Assert;
import org.junit.Test;

public class PokerTest {

    @Test
    public void should_return_1_when_given_1_player_card_value_is_3D_and_2_player_card_value_is_2D() {
        Card onePlayerCard = new Card("3D");
        Card twoPlayerCard = new Card("2D");

        Poker poker = new Poker();
        Assert.assertEquals("1", poker.judgeWhoWin(onePlayerCard, twoPlayerCard));
    }

    @Test
    public void should_return_1_when_given_1_player_card_value_is_AH_and_2_player_card_value_is_TD() {
        Card onePlayerCard = new Card("AD");
        Card twoPlayerCard = new Card("TD");

        Poker poker = new Poker();
        Assert.assertEquals("1", poker.judgeWhoWin(onePlayerCard, twoPlayerCard));
    }

    @Test
    public void should_return_draw_when_given_1_player_card_value_is_TD_and_2_player_card_value_is_TD() {
        Card onePlayerCard = new Card("TD");
        Card twoPlayerCard = new Card("TD");
        Poker poker = new Poker();
        Assert.assertEquals("draw", poker.judgeWhoWin(onePlayerCard, twoPlayerCard));
    }
}