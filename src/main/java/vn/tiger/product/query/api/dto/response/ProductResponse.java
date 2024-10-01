package vn.tiger.product.query.api.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
