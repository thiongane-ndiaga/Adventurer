package com.cirilgroup.adventurer.utils;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileUtilTests {

    @Test
    public void shouldHaveSameContentWhenFileNameIsGiven() throws URISyntaxException, IOException {
            String fileName = "FileUtilTests.txt";
            List<String> expectedLines = new ArrayList<>();
            expectedLines.add("This is a test");

            List<String> actualLines = FileUtil.getLines(this.getClass(), fileName);

            assertArrayEquals(expectedLines.toArray(), actualLines.toArray());
    }
}
