package com.cirilgroup.adventurer.utils;

import java.util.ArrayList;
import java.util.List;

public class MessagesManager {

    private static MessagesManager instance;
    public final List<String> messages;
    private MessagesManager() {
        messages = new ArrayList<>();
    }

    public void showMessages() {
        messages.forEach(messages -> System.out.println("- " + messages)
        );
    }

    public static MessagesManager getInstance() {
        if (instance == null) {
            instance = new MessagesManager();
        }
        return instance;
    }
}
