package ru.dfed.aws.service.mapper;


import org.mapstruct.Mapper;
import ru.dfed.aws.domain.Product;
import ru.dfed.aws.domain.dto.ProductDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
