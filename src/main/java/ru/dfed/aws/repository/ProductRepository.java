package ru.dfed.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dfed.aws.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
