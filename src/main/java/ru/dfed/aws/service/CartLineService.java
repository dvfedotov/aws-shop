package ru.dfed.aws.service;


import java.util.List;
import java.util.Optional;
import ru.dfed.aws.domain.CartLine;
import ru.dfed.aws.domain.dto.CartLineDTO;


public interface CartLineService {

    /**
     * Save a cartLine.
     *
     * @param cartLineDTO the entity to save.
     * @return the persisted entity.
     */
    CartLineDTO save(CartLineDTO cartLineDTO);

    /**
     * Get all the cartLines.
     *
     * @return the list of entities.
     */
    List<CartLineDTO> findAll();


    /**
     * Get the "id" cartLine.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CartLineDTO> findOne(Long id);

    /**
     * Delete the "id" cartLine.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<CartLine> findByProductId(Long productId);

    void saveCartLine(CartLine cartLine);
}
