package vn.tiger.product.command.api.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tiger.product.command.api.commands.CreateProductCommand;
import vn.tiger.product.command.api.dto.request.ProductAddRequest;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addProduct(@RequestBody ProductAddRequest request) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        return commandGateway.sendAndWait(createProductCommand);
    }
}
