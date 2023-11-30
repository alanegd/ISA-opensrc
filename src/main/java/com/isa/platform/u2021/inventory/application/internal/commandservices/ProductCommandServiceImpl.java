package com.isa.platform.u2021.inventory.application.internal.commandservices;

import com.isa.platform.u2021.inventory.domain.model.aggregates.Product;
import com.isa.platform.u2021.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.MonitoringLevel;
import com.isa.platform.u2021.inventory.domain.model.valueobjects.SerialNumber;
import com.isa.platform.u2021.inventory.domain.services.ProductCommandService;
import com.isa.platform.u2021.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {

        // Validate that product with same serialNumber does not exist

        var serialNumber = new SerialNumber(command.serialNumber());
        productRepository.findBySerialNumber(serialNumber).map(product -> {
            throw new IllegalArgumentException("Product with serial number " + command.serialNumber() + " already exists");
        });

        // Validate that MonitoringLevel is ESSENTIAL_MONITORING or ADVANCE_MONITORING
        if(!command.monitoringLevel().equals("ESSENTIAL_MONITORING") && !command.monitoringLevel().equals("ADVANCE_MONITORING")){
            throw new IllegalArgumentException("Monitoring level can only be ESSENTIAL_MONITORING or ADVANCE_MONITORING, not " + command.monitoringLevel());
        }
        // String brand, String model, String serialNumber, String monitoringLevel

        var product = new Product(
             command.brand(),
             command.model(),
             command.serialNumber(),
                MonitoringLevel.valueOf(command.monitoringLevel()));
        productRepository.save(product);
        return product.getId();
    }
}
