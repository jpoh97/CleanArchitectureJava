package com.cleanarchitecture.lievendoclo.CleanArchitecture.boundary;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel.GetBuildingRequest;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.responsemodel.BuildingResponseModel;

@FunctionalInterface
@Boundary
public interface GetBuilding {
    BuildingResponseModel execute(GetBuildingRequest request);
}
