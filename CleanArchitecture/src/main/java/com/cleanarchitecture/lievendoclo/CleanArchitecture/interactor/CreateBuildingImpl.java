package com.cleanarchitecture.lievendoclo.CleanArchitecture.interactor;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.boundary.CreateBuilding;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.entity.Building;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.entitygateway.BuildingEntityGateway;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel.CreateBuildingRequest;

import java.util.UUID;
import java.util.function.Consumer;

public class CreateBuildingImpl implements CreateBuilding {

    private final BuildingEntityGateway buildingEntityGateway;

    public CreateBuildingImpl(BuildingEntityGateway buildingEntityGateway) {
        this.buildingEntityGateway = buildingEntityGateway;
    }

    @Override
    public void execute(CreateBuildingRequest request, Consumer<String> idConsumer) {
        Building building = new Building(UUID.randomUUID().toString(), request.getName());
        idConsumer.accept(buildingEntityGateway.save(building));
    }
}
