package com.cirilgroup.adventurer.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire pour la gestion des messages/évenements du jeu
 */
public class MessagesManager {

    private static MessagesManager instance;
    public final List<String> messages;
    private MessagesManager() {
        messages = new ArrayList<>();
    }

    /**
     * Affiche les messages dans la console
     */
    public void showMessages() {
        messages.forEach(messages -> System.out.println("- " + messages)
        );
    }

    /**
     * Renvoie l'unique instance de la classe MessagesManager
     * @return
     */

    public static MessagesManager getInstance() {
        if (instance == null) {
            instance = new MessagesManager();
        }
        return instance;
    }
}
