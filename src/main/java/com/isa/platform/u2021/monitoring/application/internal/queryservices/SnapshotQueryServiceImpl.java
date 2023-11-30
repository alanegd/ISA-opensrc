package com.isa.platform.u2021.monitoring.application.internal.queryservices;

import com.isa.platform.u2021.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u2021.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u2021.monitoring.domain.model.queries.GetSnapshotByProductIdQuery;
import com.isa.platform.u2021.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u2021.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SnapshotQueryServiceImpl implements SnapshotQueryService {

    private final SnapshotRepository snapshotRepository;

    public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Optional<Snapshot> handle(GetSnapshotByIdQuery query) {
        return snapshotRepository.findById(query.id());
    }

    @Override
    public Optional<Snapshot> handle(GetSnapshotByProductIdQuery query) {
        return snapshotRepository.findByProductId(query.productId());
    }
}
