package com.cleanarchitecture.lievendoclo.CleanArchitecture.controller;

import static com.cleanarchitecture.lievendoclo.CleanArchitecture.controller.BuildingController.RESOURCE_URI_TEMPLATE;

import com.cleanarchitecture.lievendoclo.CleanArchitecture.boundary.CreateBuilding;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.boundary.GetBuilding;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.controller.payloadmodel.CreateBuildingJsonPayload;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.controller.viewmodel.BuildingJson;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.presenter.JsonBuildingResponseModelPresenter;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel.CreateBuildingRequest;
import com.cleanarchitecture.lievendoclo.CleanArchitecture.requestmodel.GetBuildingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(RESOURCE_URI_TEMPLATE)
public class BuildingController {
    static final String RESOURCE_URI_TEMPLATE = "/building";
    private static final String GET_SINGLE_BUILDING_URI_TEMPLATE = RESOURCE_URI_TEMPLATE + "/{buildingId}";

    private final CreateBuilding createBuilding;
    private final GetBuilding getBuilding;

    public BuildingController(CreateBuilding createBuilding, GetBuilding getBuilding) {
        this.createBuilding = createBuilding;
        this.getBuilding = getBuilding;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateBuildingJsonPayload payload) {
        final AtomicReference<String> id = new AtomicReference<>();
        createBuilding.execute(new CreateBuildingRequest(payload.getName()), id::set);
        return ResponseEntity.created(new UriTemplate(GET_SINGLE_BUILDING_URI_TEMPLATE).expand (id.get()).normalize())
                .header("X-Created-Id", id.get())
                .build();
    }

    //@GET
    @GetMapping("/{buildingId}")
    public BuildingJson get(@PathVariable String buildingId) {
        final JsonBuildingResponseModelPresenter presenter = new JsonBuildingResponseModelPresenter();
        getBuilding.execute(new GetBuildingRequest(buildingId));
        return presenter.getPresentedResult();
    }
}
