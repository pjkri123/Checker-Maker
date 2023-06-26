package com.model.dao;

import com.model.entity.Customer;
import com.model.entity.CustomerMaster;
import org.springframework.orm.hibernate5.HibernateTemplate;


public interface CustomerMasterDao {
    void setTemplate(HibernateTemplate template);
    void reject(String customerCode);
    void approve(String customerCode);

    CustomerMaster getCustomerByCode(String customerCode);
}
