package com.cirilgroup.adventurer.world;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTests {

    /**
     * Teste si la carte se charge correctement
     * @throws AdventurerException
     */
    @Test
    public void shouldLoadMapWhenCorrectFilenameIsGiven() throws AdventurerException {
        String filename = "MapTests.txt";

        Map map = new Map(filename);

        assertEquals(12, map.getWidth());
        assertEquals(3, map.getHeight());

    }

    /**
     * Teste si la carte ne se charge pas si un mauvais nom de fichier est fourni
     * @throws AdventurerException
     */
    @Test
    public void shouldThrowAdventurerExceptionWhenIncorrectFilenameIsGiven() throws AdventurerException {
        String filename = "NoMapTests.txt";
        assertThrows(AdventurerException.class, () -> new Map(filename));
    }

    /**
     * Teste si une cellule n'est pas marquée
     * @throws AdventurerException
     */
    @Test
    public void shouldReturnFalseWhenMarkWood() throws AdventurerException {
        String filename = "MapTests.txt";
        Map map = new Map(filename);

        assertFalse(map.markCell(0, 0, '*'));
    }

    /**
     * Teste si une cellule est marquée
     * @throws AdventurerException
     */
    @Test
    public void shouldReturnTrueWhenMarkSpace() throws AdventurerException {
        String filename = "MapTests.txt";
        Map map = new Map(filename);

        assertTrue(map.markCell(4, 0, '*'));
    }
}
