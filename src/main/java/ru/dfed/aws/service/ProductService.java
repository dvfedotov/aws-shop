package ru.dfed.aws.service;


import java.util.List;
import java.util.Optional;
import ru.dfed.aws.domain.Product;
import ru.dfed.aws.domain.dto.ProductDTO;


public interface ProductService {

    /**
     * Save a product.
     *
     * @param productDTO the entity to save.
     * @return the persisted entity.
     */
    ProductDTO save(ProductDTO productDTO);

    /**
     * Get all the products.
     *
     * @return the list of entities.
     */
    List<ProductDTO> findAll();


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    ProductDTO findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<Product> getProductByPartsNumber(String partsNumber);

    void saveProduct(Product product);

    Optional<Product>  findByName(String name);
}
