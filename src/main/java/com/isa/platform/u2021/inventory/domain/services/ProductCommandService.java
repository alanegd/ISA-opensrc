package com.isa.platform.u2021.inventory.domain.services;

import com.isa.platform.u2021.inventory.domain.model.commands.CreateProductCommand;

public interface ProductCommandService {
    Long handle(CreateProductCommand command);
}
