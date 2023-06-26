package com.service;

import com.model.dto.CustomerDTO;
import com.model.entity.Customer;

public interface MakerService {
    Customer dtoToCustomer(CustomerDTO makerDTO);
    CustomerDTO CustomerToDto(Customer customer);
}
