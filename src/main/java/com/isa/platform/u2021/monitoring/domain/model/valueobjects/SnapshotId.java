package com.isa.platform.u2021.monitoring.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record SnapshotId(String snapshotId) {
    public SnapshotId() {
        this(null);
    }
}
