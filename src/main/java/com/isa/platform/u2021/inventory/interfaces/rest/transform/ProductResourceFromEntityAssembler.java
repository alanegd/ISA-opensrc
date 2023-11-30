package com.isa.platform.u2021.inventory.interfaces.rest.transform;

import com.isa.platform.u2021.inventory.domain.model.aggregates.Product;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product entity) {
        return new ProductResource(entity.getId(), entity.getBrand(), entity.getModel(), entity.getSerialNumber(), entity.getMonitoringLevel());
    }
}
