package com.isa.platform.u2021.inventory.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum EMonitoringLevel {
    ESSENTIAL_MONITORING(1),
    ADVANCE_MONITORING(2);

    private final int value;

    EMonitoringLevel(int value) {
        this.value = value;
    }
}
