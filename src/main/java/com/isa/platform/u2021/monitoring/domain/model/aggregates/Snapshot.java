package com.isa.platform.u2021.monitoring.domain.model.aggregates;

import com.isa.platform.u2021.inventory.domain.model.aggregates.Product;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u2021.monitoring.domain.model.valueobjects.ProductSerialNumber;
import com.isa.platform.u2021.monitoring.domain.model.valueobjects.SnapshotId;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Snapshot extends AbstractAggregateRoot<Snapshot> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(name = "snapshot_id")
    private SnapshotId snapshotId;

    @Embedded
    private ProductSerialNumber productSerialNumber;

    @Getter
    private Double temperature;

    @Getter
    private Double energy;

    @Getter
    private int leakage;

    @Getter
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    public Snapshot() {
        this.snapshotId = new SnapshotId();
    }

    public Snapshot(SnapshotId snapshotId) {
        this();
        this.snapshotId = snapshotId;
    }

    public Snapshot(SnapshotId snapshotId, String productSerialNumber, Double temperature, Double energy, int leakage) {
        this.snapshotId = snapshotId;
        this.productSerialNumber = new ProductSerialNumber(productSerialNumber);
        this.temperature = temperature;
        this.energy = energy;
        this.leakage = leakage;
    }

    public String getProductSerialNumber() {
        return this.productSerialNumber.productSerialNumber();
    }

    public String getSnapshotId() {
        return this.snapshotId.snapshotId();
    }
}
