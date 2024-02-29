package com.cirilgroup.adventurer.world;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import com.cirilgroup.adventurer.utils.FileUtil;
import com.cirilgroup.adventurer.utils.MessagesManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Classe représentant un héro/aventurier
 */
public class Hero {
    private final MessagesManager messagesManager = MessagesManager.getInstance();
    private Position initialPosition;
    private Position finalPosition;
    private String movements;

    public Hero(String fileName) throws AdventurerException {

        loadHero(fileName);
        messagesManager.messages.add("Le héro est crée à la position " + initialPosition + ".");
    }

    /**
     * Permet d'initialiser le héro et ses attributs
     * @param fileName : nom du fichier contenant les informations du héro
     * @throws AdventurerException
     */
    private void loadHero(String fileName) throws AdventurerException {
        List<String> lines;

        try {
            lines = FileUtil.getLines(this.getClass(), fileName);

            String[] points = lines.get(0).split(",");
            initialPosition = new Position(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
            finalPosition = new Position(initialPosition.getX(), initialPosition.getY());

            movements = lines.get(1);
        } catch (IOException | URISyntaxException | NullPointerException e) {
            throw new AdventurerException("Impossible de charger le héro. Vérifiez si le fichier '" + fileName + "'se trouve dans resources/");
        }
    }

    /**
     * Permet de déplacer le héro sur la carte
     * @param map : objet de type Map
     */
    public void move(Map map) {

        messagesManager.messages.add("Le héro va faire les déplacements " + movements + ".");

        map.markCell(initialPosition.getX(), initialPosition.getY(),'*');

        for (char direction : movements.toCharArray()) {
            int x = finalPosition.getX();
            int y = finalPosition.getY();

            messagesManager.messages.add("Prochaine direction : " + direction + ".");

            switch (direction) {
                case 'N':
                    y--;
                    break;
                case 'S':
                    y++;
                    break;
                case 'O':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
                default:
                    messagesManager.messages.add("La direction " + direction + " n'est pas valide.");
            }

            boolean marked = map.markCell(x, y, '+');
            if(marked){
                finalPosition.setX(x);
                finalPosition.setY(y);
            }
        }
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public Position getFinalPosition() {
        return finalPosition;
    }

    public String getMovements() {
        return movements;
    }
}
