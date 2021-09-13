package ru.dfed.aws.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dfed.aws.domain.CartLine;


@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {
    Optional<CartLine> findByProductId(Long productId);
}
