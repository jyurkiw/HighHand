package com.jyurkiw.test.highhand;

import com.jyurkiw.highhand.Hand;
import com.jyurkiw.highhand.HandFactory;
import com.jyurkiw.highhand.hands.FiveOfAKind;
import com.jyurkiw.highhand.hands.StraightFlush;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void mainFiveOfAKindVsStraightFlushFOAKSubclass() {
        Hand foak = HandFactory.parseHand("AS:AD:AC:AH:JOKER");

        assertTrue(foak instanceof FiveOfAKind);
    }

    @Test
    public void mainFiveOfAKindVsStraightFlushSFSubclass() {
        Hand sf = HandFactory.parseHand("KH:QH:JH:10H:9H");

        assertTrue(sf instanceof StraightFlush);
    }

    @Test
    public void mainFiveOfAKindVsStraightFlush() {
        Hand foak = HandFactory.parseHand("AS:AD:AC:AH:JOKER");
        Hand sf = HandFactory.parseHand("KH:QH:JH:10H:9H");

        assertEquals(1, foak.compareTo(sf));
    }
}