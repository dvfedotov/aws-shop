package ru.dfed.aws.service.mapper;


import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dfed.aws.domain.CartLine;
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
}
