package com.model.dao;

import com.model.dto.CustomerDTO;
import com.model.entity.Customer;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public interface CustomerDao {
    void setTemplate(HibernateTemplate template);
    void getSave(CustomerDTO makerDTO);

    void getUpdate(CustomerDTO makerDTO);
    List<Customer> getCustomer();
    Customer getCustomerByCode(String customerCode);
    void deleteCustomer(String customerCode);
    void approve(String customerCode);

    int maxCustomerId();
}
