package com.isa.platform.u2021.monitoring.interfaces;

import com.isa.platform.u2021.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.CreateProductResource;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.ProductResource;
import com.isa.platform.u2021.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.isa.platform.u2021.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import com.isa.platform.u2021.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u2021.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u2021.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u2021.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.u2021.monitoring.interfaces.rest.resources.SnapshotResource;
import com.isa.platform.u2021.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.isa.platform.u2021.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/products/{productId}/snapshots", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Snapshots", description = "Snapshot Management Endpoints")
public class SnapshotsController {
    private final SnapshotQueryService snapshotQueryService;
    private final SnapshotCommandService snapshotCommandService;

    public SnapshotsController(SnapshotQueryService snapshotQueryService, SnapshotCommandService snapshotCommandService) {
        this.snapshotQueryService = snapshotQueryService;
        this.snapshotCommandService = snapshotCommandService;
    }

    @PostMapping
    public ResponseEntity<SnapshotResource> createSnapshot(@RequestBody CreateSnapshotResource resource) {
        var createSnapshotCommand = CreateSnapshotCommandFromResourceAssembler.toCommandFromResource(resource);
        var snapshotId = snapshotCommandService.handle(createSnapshotCommand);
        if (snapshotId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(snapshotId);
        var snapshot = snapshotQueryService.handle(getSnapshotByIdQuery);

        if (snapshot.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var snapshotResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return new ResponseEntity<>(snapshotResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<SnapshotResource> getSnapshot(@PathVariable("productId") Long productId) {
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(productId);
        var snapshot = snapshotQueryService.handle(getSnapshotByIdQuery);
        if (snapshot.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var snapshotResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return ResponseEntity.ok(snapshotResource);
    }

}
