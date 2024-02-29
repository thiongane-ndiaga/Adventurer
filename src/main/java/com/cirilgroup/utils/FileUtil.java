package com.cirilgroup.utils;

import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
    public static List<String> getLines(Class clazz, String fileName) throws URISyntaxException, IOException {

        Path path = Paths.get(clazz.getResource("/"+fileName).toURI());
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
