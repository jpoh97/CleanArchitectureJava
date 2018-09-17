package com.cleanarchitecture.lievendoclo.CleanArchitecture.entitygatewayimplementation;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.entity.Building;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.entitygateway.BuildingEntityGateway;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.entitygatewayimplementation.morphia.BuildingDocument;
import org.mongodb.morphia.Datastore;

public class MongoDbBuildingEntityGateway implements BuildingEntityGateway {
    private final Datastore datastore;

    public MongoDbBuildingEntityGateway(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public String save(Building building) {
        datastore.save(toDocument(building));
        return building.getId();
    }

    @Override
    public Building findById(String id) {
        return toDomain(datastore.get(BuildingDocument.class, id));
    }

    private BuildingDocument toDocument(Building building)  {
        return new BuildingDocument(building.getId(), building.getName());
    }

    private Building toDomain(BuildingDocument buildingDocument)  {
        return new Building(buildingDocument.getId(), buildingDocument.getName());
    }
}
