package com.isa.platform.u2021.inventory.domain.services;

import com.isa.platform.u2021.inventory.domain.model.commands.CreateProductCommand;

/**
 * ProductCommandService
 *
 * <p>
 *     This interface defines the contract for the command service that handles the product commands.
 *     The command service is responsible for handling the commands and dispatching them to the appropriate
 *     aggregate.
 * </p>
 */
public interface ProductCommandService {
    /**
     * Handles the request product command.
     * @param command The request product command.
     * @return The product id.
     * @see CreateProductCommand
     */
    Long handle(CreateProductCommand command);
}
