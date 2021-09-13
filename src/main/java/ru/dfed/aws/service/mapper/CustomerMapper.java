package ru.dfed.aws.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dfed.aws.domain.Customer;
import ru.dfed.aws.domain.dto.CustomerDTO;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {


    @Mapping(target = "shoppingCart", ignore = true)
    Customer toEntity(CustomerDTO customerDTO);

    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
