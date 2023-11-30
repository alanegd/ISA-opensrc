package com.isa.platform.u2021.monitoring.interfaces.rest.resources;

import com.isa.platform.u2021.monitoring.domain.model.valueobjects.SnapshotId;

public record CreateSnapshotResource(SnapshotId snapshotId, String productSerialNumber, Double temperature, Double energy, int leakage) {
}
