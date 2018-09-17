package com.cleanarchitecture.lievendoclo.CleanArchitecture.entitygateway;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.entity.Building;

public interface BuildingEntityGateway {
    String save(Building building);
    Building findById(String id);
}
