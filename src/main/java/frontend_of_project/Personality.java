package com.example.frontend_of_project;

public enum Personality {

    ANALYTICAL("ANALYTICAL"," Focused on solving problems through logic, data, and precision."),
    CREATIVE("CREATIVE","Generates innovative ideas and original approaches to challenges."),
    SOCIAL("SOCIAL"," Enjoys interacting, helping, and communicating effectively with others."),
    ENTERPRISING("ENTERPRISING"," Motivated to lead, influence, and achieve goals through initiative."),
    INVESTIGATIVE("INVESTIGATIVE"," Curious and driven to explore, research, and uncover the unknown.");


    private String type;
    private String description;

    Personality(String description, String type) {
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
