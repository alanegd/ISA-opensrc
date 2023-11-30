package com.isa.platform.u2021.inventory.interfaces.rest.transform;

import com.isa.platform.u2021.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.brand(), resource.model(), resource.serialNumber(), resource.monitoringLevel());
    }
}
