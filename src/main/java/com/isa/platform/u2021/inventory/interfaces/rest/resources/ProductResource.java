package com.isa.platform.u2021.inventory.interfaces.rest.resources;

/**
 * Resource for creating a product.
 * @param id
 * @param brand
 * @param model
 * @param serialNumber
 * @param monitoringLevel
 */
public record ProductResource(Long id, String brand, String model, String serialNumber, String monitoringLevel) {
}
