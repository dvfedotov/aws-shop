package ru.dfed.aws.web.rest;


import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dfed.aws.domain.dto.ShoppingCartDTO;
import ru.dfed.aws.exception.NotFoundException;
import ru.dfed.aws.service.ShoppingCartService;


@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    private final Logger log = LoggerFactory.getLogger(ShoppingCartController.class);
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/cart/{cartId}")
    public ResponseEntity<ShoppingCartDTO> getCart(@PathVariable Long cartId) {
        log.debug("REST request to get Cart");
        ShoppingCartDTO shoppingCartDTO;
        if (shoppingCartService.findById(cartId).isPresent()) {
            shoppingCartDTO = shoppingCartService.findById(cartId).get();
        } else {
            shoppingCartDTO = new ShoppingCartDTO();
            shoppingCartService.save(shoppingCartDTO);
        }
        return ResponseEntity.ok(shoppingCartDTO);
    }

    @PutMapping("/cart/{cartId}")
    public ResponseEntity<ShoppingCartDTO> updateShoppingCart(@Valid @RequestBody ShoppingCartDTO shoppingCartDTO, @PathVariable Long cartId) {
        log.debug("REST request to update Product : {}", shoppingCartDTO);
        if (shoppingCartDTO.getId() == null) {
            throw new NotFoundException("Нет параметра cartId");
        }
        ShoppingCartDTO result = shoppingCartService.save(shoppingCartDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cartId) {
        log.debug("REST request to get Product : {}", cartId);
        shoppingCartService.delete(cartId);
        return ResponseEntity.ok("The cart with " + cartId + "has been deleted");
    }
}
