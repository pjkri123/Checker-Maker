package com.service;

import com.model.dto.CustomerDTO;
import com.model.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class MakerServiceImpl implements MakerService{

    @Override
    public Customer dtoToCustomer(CustomerDTO makerDTO) {
        Customer customer = new Customer();
        customer.setCustomerCode(makerDTO.getCustomerCode());
        customer.setCustomerName(makerDTO.getCustomerName());
        customer.setCustomerAddress1(makerDTO.getCustomerAddress1());
        customer.setCustomerAddress2(makerDTO.getCustomerAddress2());
        customer.setCustomerPinCode(makerDTO.getCustomerPinCode());
        customer.setEmailAddress(makerDTO.getEmailAddress());
        customer.setContactNumber(makerDTO.getContactNumber());
        customer.setPrimaryContactPerson(makerDTO.getPrimaryContactPerson());
        customer.setRecordStatus(makerDTO.getRecordStatus());
        customer.setActiveInactiveFlag(makerDTO.getActiveInactiveFlag());
        customer.setCreateDate(makerDTO.getCreateDate());
        customer.setCreatedBy(makerDTO.getCreatedBy());
        customer.setModifiedDate(makerDTO.getModifiedDate());
        customer.setModifiedBy(makerDTO.getModifiedBy());
        customer.setAuthorizedDate(makerDTO.getAuthorizedDate());
        customer.setAuthorizedBy(makerDTO.getAuthorizedBy());
        return customer;
    }

    @Override
    public CustomerDTO CustomerToDto(Customer customer) {
        CustomerDTO makerDTO = new CustomerDTO();
        makerDTO.setCustomerCode(customer.getCustomerCode());
        makerDTO.setCustomerName(customer.getCustomerName());
        makerDTO.setCustomerAddress1(customer.getCustomerAddress1());
        makerDTO.setCustomerAddress2(customer.getCustomerAddress2());
        makerDTO.setCustomerPinCode(customer.getCustomerPinCode());
        makerDTO.setEmailAddress(customer.getEmailAddress());
        makerDTO.setContactNumber(customer.getContactNumber());
        makerDTO.setPrimaryContactPerson(customer.getPrimaryContactPerson());
        makerDTO.setRecordStatus(customer.getRecordStatus());
        makerDTO.setActiveInactiveFlag(customer.getActiveInactiveFlag());
        makerDTO.setCreateDate(customer.getCreateDate());
        makerDTO.setCreatedBy(customer.getCreatedBy());
        makerDTO.setModifiedDate(customer.getModifiedDate());
        makerDTO.setModifiedBy(customer.getModifiedBy());
        makerDTO.setAuthorizedDate(customer.getAuthorizedDate());
        makerDTO.setAuthorizedBy(customer.getAuthorizedBy());
        return makerDTO;
    }
}
