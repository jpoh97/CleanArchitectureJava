package com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel;

import javax.annotation.concurrent.Immutable;

@Immutable
public class CreateBuildingRequest {
    private final String name;

    public CreateBuildingRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
