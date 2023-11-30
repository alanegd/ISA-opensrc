package com.isa.platform.u2021.inventory.interfaces.rest.resources;

/**
 * Resource for creating a product.
 * @param Id
 * @param brand
 * @param model
 * @param serialNumber
 * @param monitoringLevel
 */
public record ProductResource(Long Id, String brand, String model, String serialNumber, String monitoringLevel) {
}
