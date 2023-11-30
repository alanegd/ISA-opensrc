package com.isa.platform.u2021.monitoring.domain.services;

import com.isa.platform.u2021.monitoring.domain.model.commands.CreateSnapshotCommand;

public interface SnapshotCommandService {
    Long handle(CreateSnapshotCommand command);
}
