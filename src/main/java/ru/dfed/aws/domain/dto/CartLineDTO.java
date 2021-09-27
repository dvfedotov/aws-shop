package ru.dfed.aws.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class CartLineDTO implements Serializable {

    @JsonIgnore
    private Long id;

    @NotNull
    @JsonIgnore
    private String productId;

    @JsonProperty("product_name")
    private String name;

    @JsonProperty("product_price")
    private Integer salesPrice;

    private Integer quantity;

    @JsonIgnore
    private Long shoppingCartId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Integer salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CartLineDTO)) {
            return false;
        }

        return id != null && id.equals(((CartLineDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CartLineDTO{" +
            "id=" + getId() +
            ", productId='" + getProductId() + "'" +
            ", salesPrice=" + getSalesPrice() +
            ", quantity=" + getQuantity() +
            ", shoppingCartId=" + getShoppingCartId() +
            "}";
    }
}
