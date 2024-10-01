package vn.tiger.product.command.api.events;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.tiger.product.command.api.dto.events.ProductCreatedEvent;
import vn.tiger.product.command.api.entities.Product;
import vn.tiger.product.command.api.repositories.ProductRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = Product.builder().build();

        BeanUtils.copyProperties(event, product);
        product.setProductId(UUID.fromString(event.getProductId()));

        productRepository.save(product);
    }

    @ExceptionHandler
    public void on(Exception exception) throws Exception {
        throw exception;
    }
}
