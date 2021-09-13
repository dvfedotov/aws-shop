package ru.dfed.aws.config;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.dfed.aws.domain.Product;
import ru.dfed.aws.service.ProductService;

@Component
public class DataInitializer {

    private final ProductService productService;

    public DataInitializer(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    private void init() {
        initProduct();

    }

    private void initProduct() {
        List<Product> categoryList = new ArrayList<>();
        categoryList.add(new Product().name("product1").partsNumber("1274682HHJ"));
        categoryList.add(new Product().name("product2").partsNumber("12758862HHJ"));
        categoryList.add(new Product().name("product3").partsNumber("127-455HHJ"));


        for (Product product : categoryList) {
            if (productService.getProductByPartsNumber(product.getPartsNumber()).isEmpty()) {
                productService.saveProduct(product);
            }
        }
    }
}
