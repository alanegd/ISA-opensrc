package com.isa.platform.u2021.inventory.interfaces.rest.transform;

import com.isa.platform.u2021.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.CreateProductResource;

/**
 * Assembler for creating a product command from a resource.
 */
public class CreateProductCommandFromResourceAssembler {
    /**
     * Create a product command from a resource.
     * @param resource The resource.
     * @return CreateProductCommand.
     */
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.brand(), resource.model(), resource.serialNumber(), resource.monitoringLevel());
    }
}
