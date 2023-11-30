package com.isa.platform.u2021.inventory.domain.model.aggregates;

import com.isa.platform.u2021.inventory.domain.model.valueobjects.EMonitoringLevel;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u2021.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Product {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String brand;

    @Getter
    private String model;

    @Embedded
    private SerialNumber serialNumber;

    @Enumerated(EnumType.ORDINAL)
    private EMonitoringLevel monitoringLevel;

    // Estos dos no me los pide el enunciado, pero lo más seguro es que vengan para el examen

    /*
    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

     */

    public Product() {

    }

    public Product(String brand, String model, String serialNumber, EMonitoringLevel monitoringLevel) {
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
