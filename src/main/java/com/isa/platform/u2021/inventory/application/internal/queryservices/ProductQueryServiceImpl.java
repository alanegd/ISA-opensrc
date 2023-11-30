package com.isa.platform.u2021.inventory.application.internal.queryservices;

import com.isa.platform.u2021.inventory.domain.model.aggregates.Product;
import com.isa.platform.u2021.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u2021.inventory.domain.model.queries.GetProductBySerialNumberQuery;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u2021.inventory.domain.services.ProductQueryService;
import com.isa.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }

    @Override
    public Optional<Product> handle(GetProductBySerialNumberQuery query) {
        return productRepository.findBySerialNumber(new SerialNumber(query.serialNumber()));
    }


}
