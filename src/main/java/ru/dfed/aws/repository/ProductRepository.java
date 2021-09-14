package ru.dfed.aws.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dfed.aws.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> getProductByPartsNumber(String partsNumber);

    Optional<Product> findByName(String name);
}
