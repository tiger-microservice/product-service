package vn.tiger.product.query.api.controllers;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tiger.product.query.api.dto.response.ProductResponse;
import vn.tiger.product.query.api.queries.GetProductsQuery;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductResponse> findAllProduct(Pageable pageable) {
        GetProductsQuery getProductsQuery = GetProductsQuery.builder().build();

        return queryGateway.query(getProductsQuery, ResponseTypes.multipleInstancesOf(ProductResponse.class)).join();
    }
}
