package ru.dfed.aws.service;

import java.util.List;
import java.util.Optional;
import ru.dfed.aws.domain.Customer;
import ru.dfed.aws.domain.dto.CustomerDTO;


public interface CustomerService {

    /**
     * Save a customer.
     *
     * @param customerDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDTO save(CustomerDTO customerDTO);

    /**
     * Get all the customers.
     *
     * @return the list of entities.
     */
    List<CustomerDTO> findAll();


    /**
     * Get the "id" customer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDTO> findOne(Long id);

    /**
     * Delete the "id" customer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<Customer> getCustomerByEmail(String email);

    void saveCustomer(Customer customer);
}
