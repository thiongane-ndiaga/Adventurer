package com.cirilgroup.adventurer.world;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTests {

    @Test
    public void shouldLoadMapWhenCorrectFilenameIsGiven() throws AdventurerException {
        String filename = "MapTests.txt";

        Map map = new Map(filename);

        assertEquals(12, map.getWidth());
        assertEquals(3, map.getHeight());

    }

    @Test
    public void shouldThrowAdventurerExceptionWhenIncorrectFilenameIsGiven() throws AdventurerException {
        String filename = "NoMapTests.txt";
        assertThrows(AdventurerException.class, () -> new Map(filename));
    }

    @Test
    public void shouldReturnFalseWhenMarkWood() throws AdventurerException {
        String filename = "MapTests.txt";
        Map map = new Map(filename);

        assertFalse(map.markCell(0, 0, '*'));
    }

    @Test
    public void shouldReturnTrueWhenMarkSpace() throws AdventurerException {
        String filename = "MapTests.txt";
        Map map = new Map(filename);

        assertTrue(map.markCell(4, 0, '*'));
    }
}
