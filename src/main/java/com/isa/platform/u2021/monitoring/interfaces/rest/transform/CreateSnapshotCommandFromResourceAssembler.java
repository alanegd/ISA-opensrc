package com.isa.platform.u2021.monitoring.interfaces.rest.transform;

import com.isa.platform.u2021.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u2021.monitoring.interfaces.rest.resources.CreateSnapshotResource;

public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand toCommandFromResource(CreateSnapshotResource resource) {

        return new CreateSnapshotCommand(resource.snapshotId(), resource.productSerialNumber(), resource.temperature(), resource.energy(), resource.leakage());
    }
}
