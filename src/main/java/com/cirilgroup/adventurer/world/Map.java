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

    private void loadMap(String filename) throws AdventurerException {
        List<String> lines;

        try {
            lines = FileUtil.getLines(this.getClass(), filename);

            setCells(new char[lines.size()][lines.get(0).length()]);

            for (int i = 0; i < lines.size(); i++) {
                cells[i] = lines.get(i).toCharArray();
            }

            setHeight(cells.length);
            setWidth(cells[0].length);

        } catch (URISyntaxException | IOException | NullPointerException e) {
            throw new AdventurerException("Impossible de charger la carte. Vérifiez si le fichier '" + filename + "'se trouve dans resources/");
        }
    }


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
