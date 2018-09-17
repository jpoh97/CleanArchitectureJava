package com.cleanarchitecture.lievendoclo.CleanArchitecture.presenter;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.controller.viewmodel.BuildingJson;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.responsemodel.BuildingResponseModel;

import java.util.function.Consumer;

public class JsonBuildingResponseModelPresenter implements Consumer<BuildingResponseModel> {
    private BuildingJson buildingJson;

    @Override
    public void accept(BuildingResponseModel buildingResponse) {
        buildingJson = new BuildingJson(buildingResponse.getId(), buildingResponse.getName());
    }

    public BuildingJson getPresentedResult() {
        return buildingJson;
    }
}
