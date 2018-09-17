package com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel;

import javax.annotation.concurrent.Immutable;

@Immutable
public class GetBuildingRequest {
    private final String buildingId;

    public GetBuildingRequest(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingId() {
        return buildingId;
    }
}
