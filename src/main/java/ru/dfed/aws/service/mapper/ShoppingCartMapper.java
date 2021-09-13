package ru.dfed.aws.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dfed.aws.domain.ShoppingCart;
import ru.dfed.aws.domain.dto.ShoppingCartDTO;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, CartLineMapper.class})
public interface ShoppingCartMapper extends EntityMapper<ShoppingCartDTO, ShoppingCart> {

    @Mapping(source = "cartLineIds", target = "cartLines")
    @Mapping(source = "customer.id", target = "customerId")
    ShoppingCartDTO toDto(ShoppingCart shoppingCart);

    @Mapping(source = "customerId", target = "customer")
    @Mapping(source = "cartLineIds", target = "cartLineIds")
    @Mapping(target = "removeCartLineId", ignore = true)
    ShoppingCart toEntity(ShoppingCartDTO shoppingCartDTO);

    default ShoppingCart fromId(Long id) {
        if (id == null) {
            return null;
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(id);
        return shoppingCart;
    }
}
