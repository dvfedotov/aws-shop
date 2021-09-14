package ru.dfed.aws.service.mapper;


import java.util.Optional;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dfed.aws.domain.CartLine;
import ru.dfed.aws.domain.Product;
import ru.dfed.aws.domain.dto.CartLineDTO;
import ru.dfed.aws.service.ProductService;

@Mapper(componentModel = "spring", uses = {ShoppingCartMapper.class})
public abstract class CartLineMapper {

    @Autowired
    ProductService productService;

    @Mapping(target = "name", ignore = true)
    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    public abstract CartLineDTO toDto(CartLine cartLine);

    @Mapping(source = "shoppingCartId", target = "shoppingCart")
    public abstract CartLine toEntity(CartLineDTO cartLineDTO);

    @AfterMapping
    void secondStepMapping(@MappingTarget CartLineDTO cartLineDTO, CartLine cartLine) {
        cartLineDTO.setName(productService.findOne(cartLine.getProductId()).getName());
    }

    @AfterMapping
    void secondStepMapping(@MappingTarget CartLine cartLine, CartLineDTO cartLineDTO) {
        Optional<Product> optionalCartLine = productService.findByName(cartLineDTO.getName());
        optionalCartLine.ifPresent(line -> cartLine.setProductId(line.getId()));
    }
}
