package com.cleanarchitecture.lievendoclo.CleanArchitecture.entitygatewayimplementation.morphia;

import org.mongodb.morphia.annotations.Id;

public class BuildingDocument {
    @Id
    private String id;
    private String name;
    protected BuildingDocument() {}

    public BuildingDocument(String id, String name) {
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
