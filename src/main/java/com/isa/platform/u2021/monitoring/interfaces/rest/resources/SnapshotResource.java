package com.isa.platform.u2021.monitoring.interfaces.rest.resources;

public record SnapshotResource(Long id, String snapshotId, String productSerialNumber, Double temperature, Double energy, int leakage) {
}
