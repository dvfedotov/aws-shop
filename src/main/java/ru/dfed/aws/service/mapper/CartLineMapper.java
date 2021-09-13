package ru.dfed.aws.service.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dfed.aws.domain.CartLine;
import ru.dfed.aws.domain.dto.CartLineDTO;

@Mapper(componentModel = "spring", uses = {ShoppingCartMapper.class})
public interface CartLineMapper extends EntityMapper<CartLineDTO, CartLine> {

    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    CartLineDTO toDto(CartLine cartLine);

    @Mapping(source = "shoppingCartId", target = "shoppingCart")
    CartLine toEntity(CartLineDTO cartLineDTO);

    default CartLine fromId(Long id) {
        if (id == null) {
            return null;
        }
        CartLine cartLine = new CartLine();
        cartLine.setId(id);
        return cartLine;
    }
}
