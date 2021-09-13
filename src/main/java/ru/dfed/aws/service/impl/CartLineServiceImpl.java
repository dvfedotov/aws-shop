package ru.dfed.aws.service.impl;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dfed.aws.domain.CartLine;
import ru.dfed.aws.domain.dto.CartLineDTO;
import ru.dfed.aws.repository.CartLineRepository;
import ru.dfed.aws.service.CartLineService;
import ru.dfed.aws.service.mapper.CartLineMapper;


@Service
@Transactional
public class CartLineServiceImpl implements CartLineService {

    private final Logger log = LoggerFactory.getLogger(CartLineServiceImpl.class);


    private final CartLineRepository cartLineRepository;

    private final CartLineMapper cartLineMapper;

    public CartLineServiceImpl(CartLineRepository cartLineRepository, CartLineMapper cartLineMapper) {
        this.cartLineRepository = cartLineRepository;
        this.cartLineMapper = cartLineMapper;
    }

    @Override
    public CartLineDTO save(CartLineDTO cartLineDTO) {
        log.debug("Request to save CartLine : {}", cartLineDTO);
        CartLine cartLine = cartLineMapper.toEntity(cartLineDTO);
        cartLine = cartLineRepository.save(cartLine);
        return cartLineMapper.toDto(cartLine);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartLineDTO> findAll() {
        log.debug("Request to get all CartLines");
        return cartLineRepository.findAll().stream()
            .map(cartLineMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CartLineDTO> findOne(Long id) {
        log.debug("Request to get CartLine : {}", id);
        return cartLineRepository.findById(id)
            .map(cartLineMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CartLine : {}", id);
        cartLineRepository.deleteById(id);
    }

    @Override
    public Optional<CartLine> findByProductId(Long productId) {
        return cartLineRepository.findByProductId(productId);
    }

    @Override
    public void saveCartLine(CartLine cartLine) {
        cartLineRepository.save(cartLine);
    }
}
