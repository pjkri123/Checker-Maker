package com.model.dao;

import com.model.dto.CustomerDTO;
import com.model.entity.Customer;
import com.model.entity.CustomerMaster;
import com.service.MakerServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    HibernateTemplate template;

    @Autowired
    MakerServiceImpl makerService;

    @Override
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    @Transactional(readOnly = false)
    public void getSave(CustomerDTO makerDTO){
        Customer customer = this.makerService.dtoToCustomer(makerDTO);
        this.template.save(customer);
    }

    @Override
    @Transactional(readOnly = false)
    public void getUpdate(CustomerDTO makerDTO){
        Customer customer = this.makerService.dtoToCustomer(makerDTO);
        this.template.update(customer);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Customer> getCustomer() {
        List<Customer> customers = this.template.loadAll(Customer.class);
        int max = 0;
        for(Customer customer: customers) {
            if(customer.getCustomerId()>max) {
                max = customer.getCustomerId();
            }
        }
        return customers;
    }

    @Override
    @Transactional(readOnly = false)
    public Customer getCustomerByCode(String customerCode) {
        return this.template.get(Customer.class, customerCode);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteCustomer(String customerCode) {
        Customer customer = new Customer();
        customer.setCustomerCode(customerCode);
        this.template.delete(customer);
    }
    @Override
    @Transactional(readOnly = false)
    public void approve(String customerCode) {
        Customer e = template.get(Customer.class, customerCode);
        e.setRecordStatus("A");
        e.setAuthorizedDate(Date.valueOf(LocalDate.now()));
        e.setAuthorizedBy("checker");
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerMaster customermapper=modelMapper.map(e, CustomerMaster.class);
        template.save(customermapper);
   }

   @Override
    public int maxCustomerId() {
       List<Customer> customers = this.template.loadAll(Customer.class);
       int max = 0;
       for(Customer customer: customers) {
           if(customer.getCustomerId()>max) {
               max = customer.getCustomerId();
           }
       }
       return ++max;
   }
}

