package ru.dfed.aws.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.dfed.aws.domain.CartLine;
import ru.dfed.aws.domain.Customer;
import ru.dfed.aws.domain.Product;
import ru.dfed.aws.domain.ShoppingCart;
import ru.dfed.aws.service.CartLineService;
import ru.dfed.aws.service.CustomerService;
import ru.dfed.aws.service.ProductService;
import ru.dfed.aws.service.ShoppingCartService;

@Component
public class DataInitializer {

    private final ProductService productService;
    private final CustomerService customerService;
    private final ShoppingCartService shoppingCartService;
    private final CartLineService cartLineService;


    public DataInitializer(ProductService productService, CustomerService customerService, ShoppingCartService shoppingCartService,
                           CartLineService cartLineService) {
        this.productService = productService;
        this.customerService = customerService;
        this.shoppingCartService = shoppingCartService;
        this.cartLineService = cartLineService;
    }

    @PostConstruct
    private void init() {
        initProduct();
        initCustomer();
        initShoppingCart();
    }

    private void initProduct() {
        List<Product> categoryList = new ArrayList<>();
        categoryList.add(new Product().name("product1").partsNumber("1274682HHJ").price(100));
        categoryList.add(new Product().name("product2").partsNumber("12758862HHJ").price(150));
        categoryList.add(new Product().name("product3").partsNumber("127-455HHJ").price(250));

        for (Product product : categoryList) {
            if (productService.getProductByPartsNumber(product.getPartsNumber()).isEmpty()) {
                productService.saveProduct(product);
            }
        }
    }

    private void initCustomer() {
        Customer customer = new Customer();
        customer.name("Ivan").lastName("Ivanov").email("ivanov@yaya.ru");
        if (customerService.getCustomerByEmail(customer.getEmail()).isEmpty()) {
            customerService.saveCustomer(customer);
        }
    }

    private void initShoppingCart() {
        Set<CartLine> cartLineSet = new HashSet<>();
        CartLine cartLine1 = new CartLine();
        cartLine1.setProductId(productService.getProductByPartsNumber("1274682HHJ").get().getId());
        cartLine1.quantity(10).salesPrice(150);
        cartLineSet.add(cartLine1);
        CartLine cartLine2 = new CartLine();
        cartLine2.setProductId(productService.getProductByPartsNumber("12758862HHJ").get().getId());
        cartLine2.quantity(2).salesPrice(200);
        cartLineSet.add(cartLine2);
        CartLine cartLine3 = new CartLine();
        cartLine3.setProductId(productService.getProductByPartsNumber("127-455HHJ").get().getId());
        cartLine3.quantity(1).salesPrice(500);
        cartLineSet.add(cartLine3);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setRevisionNumber("1");
        shoppingCart.setCartLineIds(cartLineSet);
        Customer customer = customerService.getCustomerByEmail("ivanov@yaya.ru").get();
        shoppingCart.setCustomer(customer);

        if (shoppingCartService.findByCustomer(customer).isEmpty()) {
            shoppingCartService.save(shoppingCart);
        }

        for (CartLine cartLine : cartLineSet) {
            if (cartLineService.findByProductId(cartLine.getProductId()).isEmpty()) {
                cartLine.setShoppingCart(shoppingCart);
                cartLineService.saveCartLine(cartLine);
            }
        }
    }
}
