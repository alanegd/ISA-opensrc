package com.isa.platform.u2021.monitoring.application.internal.outboundservices.acl;

import com.isa.platform.u2021.inventory.interfaces.acl.ProductsContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalProductService {
    private final ProductsContextFacade productsContextFacade;

    public ExternalProductService(ProductsContextFacade productsContextFacade) {
        this.productsContextFacade = productsContextFacade;
    }

    public String fetchProductMonitoringLevelBySerialNumber(String serialNumber) {
        var productMonitoringLevel = productsContextFacade.getProductMonitoringLevelBySerialNumber(serialNumber);
        if (productMonitoringLevel.isEmpty()) return "";
        return productMonitoringLevel;
    }
}
