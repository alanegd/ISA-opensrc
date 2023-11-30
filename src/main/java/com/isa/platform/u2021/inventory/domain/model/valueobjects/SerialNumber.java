package com.isa.platform.u2021.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SerialNumber(String serialNumber) {
    public SerialNumber() {
        this(null);
    }

    public SerialNumber {
        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Serial number cannot be null or blank");
        }
    }
}
