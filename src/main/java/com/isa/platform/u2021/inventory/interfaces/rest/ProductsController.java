package com.isa.platform.u2021.inventory.interfaces.rest;

import com.isa.platform.u2021.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u2021.inventory.domain.services.ProductCommandService;
import com.isa.platform.u2021.inventory.domain.services.ProductQueryService;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.CreateProductResource;
import com.isa.platform.u2021.inventory.interfaces.rest.resources.ProductResource;
import com.isa.platform.u2021.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.isa.platform.u2021.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller for managing products.
 * <p>
 * This controller exposes the following endpoints:
 * <ul>
 *     <li>POST /api/v1/products</li>
 *     <li>GET /api/v1/products/{productId}</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping(value="/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Product Management Endpoints")
public class ProductsController {
    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

    public ProductsController(ProductQueryService productQueryService, ProductCommandService productCommandService) {
        this.productQueryService = productQueryService;
        this.productCommandService = productCommandService;
    }

    /**
     * {@code POST /api/v1/products} : Creates a product.
     *
     * @param resource the product resource to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and the created product resource in body.
     * @see ProductResource
     */
    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource resource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(resource);
        var productId = productCommandService.handle(createProductCommand);
        if (productId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);

        if (product.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    /**
     * {@code GET /api/v1/products/{productId}} : Get a product by id.
     *
     * @param productId the product id.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the product resource in body.
     * @see ProductResource
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId) {
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }
}
