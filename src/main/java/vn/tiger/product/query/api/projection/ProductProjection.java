package vn.tiger.product.query.api.projection;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import vn.tiger.product.command.api.entities.Product;
import vn.tiger.product.command.api.repositories.ProductRepository;
import vn.tiger.product.query.api.dto.response.ProductResponse;
import vn.tiger.product.query.api.queries.GetProductsQuery;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductResponse> handler(GetProductsQuery getProductsQuery) {
        List<Product> products = productRepository.findAll();

        return products.stream().map(item -> {
            ProductResponse productRes = ProductResponse.builder().build();
            BeanUtils.copyProperties(item, productRes);
            return productRes;
        }).collect(Collectors.toList());
    }
}
