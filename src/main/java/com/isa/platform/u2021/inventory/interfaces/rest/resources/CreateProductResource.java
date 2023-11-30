package com.isa.platform.u2021.inventory.interfaces.rest.resources;

/**
 * Resource for creating a product.
 * @param brand
 * @param model
 * @param serialNumber
 * @param monitoringLevel
 */
public record CreateProductResource(String brand, String model, String serialNumber, String monitoringLevel) {
}
