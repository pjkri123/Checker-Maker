package com.service;

import com.model.dto.CustomerDTO;
import com.model.entity.Customer;
import com.model.entity.CustomerMaster;
import org.springframework.stereotype.Service;

@Service
public class CheckerServiceImpl implements CheckerService{

    @Override
    public CustomerMaster dtoToCustomer(CustomerDTO checkerDTO) {
        CustomerMaster customer = new CustomerMaster();
        customer.setCustomerId(checkerDTO.getCustomerId());
        customer.setCustomerCode(checkerDTO.getCustomerCode());
        customer.setCustomerName(checkerDTO.getCustomerName());
        customer.setCustomerAddress1(checkerDTO.getCustomerAddress1());
        customer.setCustomerAddress2(checkerDTO.getCustomerAddress2());
        customer.setCustomerPinCode(checkerDTO.getCustomerPinCode());
        customer.setEmailAddress(checkerDTO.getEmailAddress());
        customer.setContactNumber(checkerDTO.getContactNumber());
        customer.setPrimaryContactPerson(checkerDTO.getPrimaryContactPerson());
        customer.setRecordStatus(checkerDTO.getRecordStatus());
        customer.setActiveInactiveFlag(checkerDTO.getActiveInactiveFlag());
        customer.setCreateDate(checkerDTO.getCreateDate());
        customer.setCreatedBy(checkerDTO.getCreatedBy());
        customer.setModifiedDate(checkerDTO.getModifiedDate());
        customer.setModifiedBy(checkerDTO.getModifiedBy());
        customer.setAuthorizedDate(checkerDTO.getAuthorizedDate());
        customer.setAuthorizedBy(checkerDTO.getAuthorizedBy());
        return customer;
    }

    @Override
    public CustomerDTO CustomerToDto(Customer customer) {
        CustomerDTO checkerDTO = new CustomerDTO();
        checkerDTO.setCustomerId(customer.getCustomerId());
        checkerDTO.setCustomerCode(customer.getCustomerCode());
        checkerDTO.setCustomerName(customer.getCustomerName());
        checkerDTO.setCustomerAddress1(customer.getCustomerAddress1());
        checkerDTO.setCustomerAddress2(customer.getCustomerAddress2());
        checkerDTO.setCustomerPinCode(customer.getCustomerPinCode());
        checkerDTO.setEmailAddress(customer.getEmailAddress());
        checkerDTO.setContactNumber(customer.getContactNumber());
        checkerDTO.setPrimaryContactPerson(customer.getPrimaryContactPerson());
        checkerDTO.setRecordStatus(customer.getRecordStatus());
        checkerDTO.setActiveInactiveFlag(customer.getActiveInactiveFlag());
        checkerDTO.setCreateDate(customer.getCreateDate());
        checkerDTO.setCreatedBy(customer.getCreatedBy());
        checkerDTO.setModifiedDate(customer.getModifiedDate());
        checkerDTO.setModifiedBy(customer.getModifiedBy());
        checkerDTO.setAuthorizedDate(customer.getAuthorizedDate());
        checkerDTO.setAuthorizedBy(customer.getAuthorizedBy());
        return checkerDTO;
    }

    @Override
    public CustomerMaster customerTempToCustomerMaster(Customer customer) {
        CustomerMaster customerMaster = new CustomerMaster();
        customerMaster.setCustomerId(customer.getCustomerId());
        customerMaster.setCustomerCode(customer.getCustomerCode());
        customerMaster.setCustomerName(customer.getCustomerName());
        customerMaster.setCustomerAddress1(customer.getCustomerAddress1());
        customerMaster.setCustomerAddress2(customer.getCustomerAddress2());
        customerMaster.setCustomerPinCode(customer.getCustomerPinCode());
        customerMaster.setEmailAddress(customer.getEmailAddress());
        customerMaster.setContactNumber(customer.getContactNumber());
        customerMaster.setPrimaryContactPerson(customer.getPrimaryContactPerson());
        customerMaster.setRecordStatus(customer.getRecordStatus());
        customerMaster.setActiveInactiveFlag(customer.getActiveInactiveFlag());
        customerMaster.setCreateDate(customer.getCreateDate());
        customerMaster.setCreatedBy(customer.getCreatedBy());
        customerMaster.setModifiedDate(customer.getModifiedDate());
        customerMaster.setModifiedBy(customer.getModifiedBy());
        customerMaster.setAuthorizedDate(customer.getAuthorizedDate());
        customerMaster.setAuthorizedBy(customer.getAuthorizedBy());
        return customerMaster;
    }
}
