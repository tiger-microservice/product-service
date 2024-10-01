package vn.tiger.product.command.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddRequest {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
