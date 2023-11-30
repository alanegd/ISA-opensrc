package com.isa.platform.u2021.monitoring.application.internal.commandservices;

import com.isa.platform.u2021.monitoring.domain.model.aggregates.Snapshot;
import com.isa.platform.u2021.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u2021.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u2021.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

@Service
public class SnapshotCommandServiceImpl implements SnapshotCommandService {

    private final SnapshotRepository snapshotRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Long handle(CreateSnapshotCommand command) {

        var existingSnapshotId = snapshotRepository.findBySnapshotId(command.snapshotId()).map(snapshot -> {
            throw new IllegalArgumentException("Snapshot with snapshotId " + command.snapshotId() + " already exists");
        });

        // Validate leakage is 0 or 1
        if(command.leakage() != 0 && command.leakage() != 1){
            throw new IllegalArgumentException("Leakage can only be 0 or 1, not " + command.leakage());
        }

        var snapshot = new Snapshot(
                command.snapshotId(),
                command.productSerialNumber(),
                command.temperature(),
                command.energy(),
                command.leakage()
        );
        snapshotRepository.save(snapshot);
        return snapshot.getId();
    }
}
