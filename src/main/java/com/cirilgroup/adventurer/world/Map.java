package com.cirilgroup.adventurer.world;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import com.cirilgroup.adventurer.utils.FileUtil;
import com.cirilgroup.adventurer.utils.MessagesManager;
import com.cirilgroup.adventurer.utils.TextColors;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Map {

    private final MessagesManager messagesManager = MessagesManager.getInstance();

    private char[][] cells;

    private int width;
    private int height;

    public Map(String filename) throws AdventurerException {

        loadMap(filename);
        messagesManager.messages.add("Carte chargée, dimensions : " + getWidth() + " sur " + getHeight());
    }

    /**
     * Permet d'initialiser la carte et ses attributs
     * @param filename : nom du fichier contenant la carte
     * @throws AdventurerException
     */
    private void loadMap(String filename) throws AdventurerException {
        List<String> lines;

        try {
            lines = FileUtil.getLines(this.getClass(), filename);

            setHeight(lines.size());
            setWidth(lines.get(0).length());
            setCells(new char[height][width]);

            lines.forEach(line -> {

            });

            for (int i = 0; i < height; i++) {
                // Vérification de la taille des lignes (Elles doivent être de même taille)
                if(lines.get(i).length() < width) {
                    throw new AdventurerException("Impossible de charger la carte. La taille de la ligne " + (i+1) + " est différente des premières.");
                }
                cells[i] = lines.get(i).toCharArray();
            }


        } catch (URISyntaxException | IOException | NullPointerException e) {
            throw new AdventurerException("Impossible de charger la carte. Vérifiez si le fichier '" + filename + "'se trouve dans resources/");
        }
    }

    /**
     * Permet de marquer une cellule sur la carte, si celle n'est pas déjà marquée et qu'elle n'est pas occupée par les bois impénétrables
     * @param x : coordonnées x
     * @param y : coordonnées y
     * @param c : caractère à marquer sur la cellule
     * @return
     */
    public boolean markCell(int x, int y, char c) {

        boolean marked = false;

        if ((x >= 0 && x < width) && (y >= 0 && y < height)) {

            switch (getCell(x, y)) {
                case '*':
                case '+':
                    break;
                case ' ':
                    cells[y][x] = c;
                    marked = true;
                    break;
                case '#':
                    messagesManager.messages.add("La case ("+x+","+y+") est occupée par les bois impénétrables.");
                    break;
                default:
                    messagesManager.messages.add("La case ("+x+","+y+") est une zone inconnue.");
                    break;
            }
        } else {
            messagesManager.messages.add("Vous êtes hors des limites de la carte.");
        }

        return marked;
    }

    /**
     * Permet d'afficher la carte sur la console
     * En vert : les bois impénétrables
     * En bleu : les déplacements du héro
     */
    public void drawMap() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if(cells[y][x] == '*' || cells[y][x]=='+'){
                    System.out.print("" + TextColors.BLUE + cells[y][x] + TextColors.RESET);
                } else {
                    System.out.print("" + TextColors.GREEN + cells[y][x] + TextColors.RESET);
                }
            }
            System.out.print("\n");
        }
    }

    private char getCell(int x, int y) {
        return cells[y][x];
    }

    public char[][] getCells() {
        return cells;
    }

    private void setCells(char[][] cells) {
        this.cells = cells;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
