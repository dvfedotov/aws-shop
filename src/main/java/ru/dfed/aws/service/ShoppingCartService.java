package ru.dfed.aws.service;


import java.util.List;
import java.util.Optional;
import ru.dfed.aws.domain.Customer;
import ru.dfed.aws.domain.ShoppingCart;
import ru.dfed.aws.domain.dto.ShoppingCartDTO;


public interface ShoppingCartService {


    ShoppingCartDTO save(ShoppingCartDTO shoppingCartDTO);

    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCartDTO> findAll();

    Optional<ShoppingCartDTO> findById(Long id);

    void delete(Long id);

    Optional<ShoppingCart> findByCustomer(Customer customer);
}
