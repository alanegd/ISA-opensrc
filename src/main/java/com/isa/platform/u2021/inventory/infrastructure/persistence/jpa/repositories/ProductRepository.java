package com.isa.platform.u2021.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u2021.inventory.domain.model.aggregates.Product;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.SerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySerialNumber(SerialNumber serialNumber);
}
