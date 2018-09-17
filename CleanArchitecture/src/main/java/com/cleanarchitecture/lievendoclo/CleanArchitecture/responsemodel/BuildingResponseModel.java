package com.cleanarchitecture.lievendoclo.CleanArchitecture.responsemodel;

import javax.annotation.concurrent.Immutable;
import java.util.function.Function;

@Immutable
public class BuildingResponseModel {
    private final String id;
    private final String name;

    public BuildingResponseModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public <T> T present(Function<BuildingResponseModel, T> presentFunction) {
        return presentFunction.apply(this);
    }
}
