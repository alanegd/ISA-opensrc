package com.isa.platform.u2021.inventory.domain.model.aggregates;

import com.isa.platform.u2021.inventory.domain.model.valueobjects.MonitoringLevel;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.SerialNumber;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * Represents a product.
 * The product is an aggregate root
 */
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product extends AbstractAggregateRoot<Product> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String brand;

    @Getter
    private String model;

    /**
     * The serial number for this product
     */
    @Embedded
    private SerialNumber serialNumber;

    @Enumerated(EnumType.ORDINAL)
    private MonitoringLevel monitoringLevel;

    // Estos dos no me los pide el enunciado, pero lo más seguro es que vengan para el examen

    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    public Product() {

    }

    public Product(String brand, String model, String serialNumber, MonitoringLevel monitoringLevel) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = new SerialNumber(serialNumber);
        this.monitoringLevel = monitoringLevel;
    }

    public String getSerialNumber() {
        return this.serialNumber.serialNumber();
    }

    public String getMonitoringLevel() {
        return this.monitoringLevel.name();
    }

}
