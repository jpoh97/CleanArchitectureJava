package com.cleanarchitecture.lievendoclo.CleanArchitecture.boundary;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel.CreateBuildingRequest;

import java.util.function.Consumer;

@FunctionalInterface
@Boundary
public interface CreateBuilding {
    void execute(CreateBuildingRequest request, Consumer<String> idConsumer);
}
