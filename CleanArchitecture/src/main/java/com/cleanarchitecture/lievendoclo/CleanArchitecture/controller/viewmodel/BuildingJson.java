package com.cleanarchitecture.lievendoclo.CleanArchitecture.controller.viewmodel;

import javax.annotation.concurrent.Immutable;

@Immutable
public class BuildingJson {
    private final String id;
    private final String name;

    public BuildingJson(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
