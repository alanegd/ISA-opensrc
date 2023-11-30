package com.isa.platform.u2021.monitoring.domain.model.commands;

import com.isa.platform.u2021.monitoring.domain.model.valueobjects.SnapshotId;

public record CreateSnapshotCommand(SnapshotId snapshotId, String productSerialNumber, Double temperature, Double energy, int leakage) {
}
