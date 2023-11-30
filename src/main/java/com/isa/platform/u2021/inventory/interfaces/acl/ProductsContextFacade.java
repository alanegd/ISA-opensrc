package com.isa.platform.u2021.inventory.interfaces.acl;

import com.isa.platform.u2021.inventory.domain.model.queries.GetProductBySerialNumberQuery;
import com.isa.platform.u2021.inventory.domain.services.ProductQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProductsContextFacade {
    private final ProductQueryService productQueryService;

    public ProductsContextFacade(ProductQueryService productQueryService) {
        this.productQueryService = productQueryService;
    }

    public String getProductMonitoringLevelBySerialNumber(String serialNumber) {
        var getProductBySerialNumber = new GetProductBySerialNumberQuery(serialNumber);
        var product = productQueryService.handle(getProductBySerialNumber);
        if (product.isEmpty()) return "";
        return product.get().getMonitoringLevel();
    }
}
