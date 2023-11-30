package com.isa.platform.u2021.monitoring.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u2021.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u2021.monitoring.domain.model.valueobjects.SnapshotId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
        Optional<Snapshot> findBySnapshotId(SnapshotId snapshotId);
        Optional<Snapshot> findByProductId(Long productId);
}
