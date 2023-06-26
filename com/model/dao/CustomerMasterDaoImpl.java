package com.model.dao;

import com.model.entity.Customer;
import com.model.entity.CustomerMaster;
import com.service.CheckerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class CustomerMasterDaoImpl implements CustomerMasterDao {

    @Autowired
    HibernateTemplate template;

    @Autowired
    CheckerService checkerService;

    @Override
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    @Transactional(readOnly = false)
    public void approve(String customerCode) {
        Customer e = template.get(Customer.class, customerCode);
        CustomerMaster customerMaster = checkerService.customerTempToCustomerMaster(e);
        customerMaster.setRecordStatus("A");
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerMaster customermapper=modelMapper.map(e,CustomerMaster.class);
        template.save(customermapper);
    }


    @Override
    @Transactional(readOnly = false)
    public void reject(String customerCode) {
        Customer customer = new Customer();
        customer.setCustomerCode(customerCode);
        this.template.update(customer);
    }
    @Override
    @Transactional(readOnly = false)
    public CustomerMaster getCustomerByCode(String customerCode) {
        return this.template.get(CustomerMaster.class, customerCode);
    }
}
