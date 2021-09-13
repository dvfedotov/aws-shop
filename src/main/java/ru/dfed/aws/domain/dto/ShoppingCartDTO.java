package ru.dfed.aws.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ShoppingCartDTO implements Serializable {

    @JsonProperty("cart_id")
    private Long id;


    @JsonIgnore
    private String revisionNumber;

    @JsonIgnore
    private LocalDate orderDate;

    @JsonIgnore
    private Long customerId;

    @JsonProperty("products")
    private List<CartLineDTO> cartLines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<CartLineDTO> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLineDTO> cartLines) {
        this.cartLines = cartLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShoppingCartDTO)) {
            return false;
        }

        return id != null && id.equals(((ShoppingCartDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
            "id=" + getId() +
            ", revisionNumber='" + getRevisionNumber() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", customerId=" + getCustomerId() +
            "}";
    }
}
