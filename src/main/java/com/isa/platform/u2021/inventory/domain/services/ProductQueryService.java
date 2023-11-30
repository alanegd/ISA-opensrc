package com.isa.platform.u2021.inventory.domain.services;

import com.isa.platform.u2021.inventory.domain.model.aggregates.Product;
import com.isa.platform.u2021.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u2021.inventory.domain.model.queries.GetProductBySerialNumberQuery;

import java.util.Optional;

/**
 * ProductQueryService is the interface that defines the contract for the Product Query Service.
 * The Product Query Service is responsible for handling all the queries related to the Product Aggregate.
 */
public interface ProductQueryService {
    /**
     * This method handles the {@link GetProductByIdQuery} query.
     * @param query the {@link GetProductByIdQuery} query.
     * @return the {@link Product} entity.
     */
    Optional<Product> handle(GetProductByIdQuery query);

    Optional<Product> handle(GetProductBySerialNumberQuery query);
}
