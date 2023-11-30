package com.isa.platform.u2021.monitoring.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductSerialNumber(String productSerialNumber) {
    public ProductSerialNumber() {
        this(null);
    }

    public ProductSerialNumber {
        if (productSerialNumber == null || productSerialNumber.isBlank()) {
            throw new IllegalArgumentException("Product serial number cannot be null or blank");
        }
    }
}
