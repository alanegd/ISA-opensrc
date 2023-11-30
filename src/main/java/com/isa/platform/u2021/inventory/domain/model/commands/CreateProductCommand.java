package com.isa.platform.u2021.inventory.domain.model.commands;

public record CreateProductCommand(String brand, String model, String serialNumber, String monitoringLevel) {
}
