package com.cirilgroup.adventurer.world;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTests {

    /**
     * Teste si le héro est chargé correctement
     * @throws AdventurerException
     */
    @Test
    public void shouldLoadHeroWhenCorrectFilenameIsGiven() throws AdventurerException {
        String filename = "HeroTests.txt";

        Hero hero = new Hero(filename);

        assertEquals(hero.getInitialPosition().getX(), 4);
        assertEquals(hero.getInitialPosition().getY(), 0);
        assertEquals("SEEEEEEN", hero.getMovements());

    }

    /**
     * Teste si le héro ne se charge pas si un mauvais nom de fichier est fourni
     * @throws AdventurerException
     */
    @Test
    public void shouldThrowAdventurerExceptionWhenIncorrectFilenameIsGiven() throws AdventurerException {
        String filename = "NoHeroTests.txt";
        assertThrows(AdventurerException.class, () -> new Map(filename));
    }

    /**
     * Teste si le héro est déplacé correctement
     * @throws AdventurerException
     */
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
