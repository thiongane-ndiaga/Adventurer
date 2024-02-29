package com.cirilgroup.adventurer.utils;

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

/**
 * Classe utilitaire pour la gestion des fichiers
 */
public class FileUtil {

    /**
     * Renvoie le contenu d'un fichier donné
     * @param clazz : classe de l'objet appelant la méthode, permet de localiser le dossier 'resources' du projet
     * @param fileName : nom du fichier
     * @return le contenu du fichier sous forme d'une liste de String'
     * @throws URISyntaxException
     * @throws IOException
     */
    public static List<String> getLines(Class clazz, String fileName) throws URISyntaxException, IOException {

        Path path = Paths.get(clazz.getResource("/"+fileName).toURI());
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
