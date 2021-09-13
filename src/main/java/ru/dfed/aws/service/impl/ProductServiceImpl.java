package ru.dfed.aws.service.impl;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dfed.aws.domain.Product;
import ru.dfed.aws.domain.dto.ProductDTO;
import ru.dfed.aws.exception.NotFoundException;
import ru.dfed.aws.repository.ProductRepository;
import ru.dfed.aws.service.ProductService;
import ru.dfed.aws.service.mapper.ProductMapper;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        log.debug("Request to save Product : {}", productDTO);
        Product product = productMapper.toEntity(productDTO);
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        log.debug("Request to get all Products");
        return productRepository.findAll().stream()
            .map(productMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public ProductDTO findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findById(id)
            .map(productMapper::toDto)
            .orElseThrow(
                () -> new NotFoundException(String.format("Товар с кодом %s не найден", id)));
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductByPartsNumber(String partsNumber) {
        return productRepository.getProductByPartsNumber(partsNumber);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

}
