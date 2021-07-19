package ru.dfed.aws.domain.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class ProductDTO implements Serializable {

    //    @JsonIgnore
    private Long id;

    @NotNull
    private String name;

    private String partsNumber;


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

    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", partsNumber='" + getPartsNumber() + "'" +
            "}";
    }
}
