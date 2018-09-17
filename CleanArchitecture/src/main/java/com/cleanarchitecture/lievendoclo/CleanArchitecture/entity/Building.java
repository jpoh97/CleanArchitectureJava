package com.cleanarchitecture.lievendoclo.CleanArchitecture.entity;

public class Building {
    private final String id;
    private final String name;

    public Building(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
