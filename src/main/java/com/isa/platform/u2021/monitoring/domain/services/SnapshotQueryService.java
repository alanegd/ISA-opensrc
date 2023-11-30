package com.isa.platform.u2021.monitoring.domain.services;

import com.isa.platform.u2021.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u2021.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u2021.monitoring.domain.model.queries.GetSnapshotByProductIdQuery;

import java.util.Optional;

public interface SnapshotQueryService {
    Optional<Snapshot> handle(GetSnapshotByIdQuery query);
    Optional<Snapshot> handle(GetSnapshotByProductIdQuery query);
}
