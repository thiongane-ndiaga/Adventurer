package com.cirilgroup.adventurer.world;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTests {

    @Test
    public void shouldLoadHeroWhenCorrectFilenameIsGiven() throws AdventurerException {
        String filename = "HeroTests.txt";

        Hero hero = new Hero(filename);

        assertEquals(hero.getInitialPosition().getX(), 4);
        assertEquals(hero.getInitialPosition().getY(), 0);
        assertEquals("SEEEEEEN", hero.getMovements());

    }

    @Test
    public void shouldThrowAdventurerExceptionWhenIncorrectFilenameIsGiven() throws AdventurerException {
        String filename = "NoHeroTests.txt";
        assertThrows(AdventurerException.class, () -> new Map(filename));
    }

    @Test
    public void shouldGotRightPositionWhenHeroMoves() throws AdventurerException {
        String heroFilename = "HeroTests.txt";
        String mapFilename = "MapTests.txt";
        Hero hero = new Hero(heroFilename);
        Map map = new Map(mapFilename);

        hero.move(map);

        assertEquals(hero.getFinalPosition().getX(), 9);
        assertEquals(hero.getFinalPosition().getY(), 1);
    }
}
