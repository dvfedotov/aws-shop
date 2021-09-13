package ru.dfed.aws.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class ProductDTO implements Serializable {

    @JsonIgnore
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String partsNumber;

    private Integer price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartsNumber() {
        return partsNumber;
    }

    public void setPartsNumber(String partsNumber) {
        this.partsNumber = partsNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", partsNumber='" + getPartsNumber() + "'" +
            ", price=" + getPrice() +
            "}";
    }
}
