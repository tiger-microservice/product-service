package vn.tiger.product.command.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tiger.product.command.api.entities.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
