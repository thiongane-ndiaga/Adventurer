package com.cirilgroup.adventurer;

import com.cirilgroup.adventurer.exceptions.AdventurerException;
import com.cirilgroup.adventurer.utils.MessagesManager;
import com.cirilgroup.adventurer.world.Hero;
import com.cirilgroup.adventurer.world.Map;

import java.util.Scanner;

public class AdventurerApp {
    private static final MessagesManager messagesManager = MessagesManager.getInstance();

    public static void main(String[] args) {

        try {
            Hero hero = getHero();
            Map map = getMap();

            hero.move(map);

            messagesManager.messages.add("Le héro a terminé son aventure.");

            messagesManager.showMessages();

            String lastPositionString = hero.getFinalPosition() == null ? "inconnue" : hero.getFinalPosition().toString();
            System.out.println("Dernière position : "+ lastPositionString);

            map.drawMap();

        } catch (AdventurerException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\nFin de l'aventure.");

    }

    private static Hero getHero() throws AdventurerException {
        return new Hero(askFileName("les informations sur le héro", "hero.txt"));
    }

    private static Map getMap() throws AdventurerException {
        return new Map(askFileName("la carte", "carte v2.txt"));
    }

    private static String askFileName(String description, String defaultFileName) {
        System.out.print("Quel est le nom du fichier contenant " + description + " ?\n[appuyez sur ENTRER pour utiliser le fichier par défaut: " + defaultFileName + "]\n");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();

        if(filename == null || filename.isEmpty()) {
            return defaultFileName;
        }
        return filename;
    }
}