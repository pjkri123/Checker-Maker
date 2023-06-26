package com.controller;

import com.model.dao.CustomerDao;
import com.model.dto.CustomerDTO;
import com.model.entity.Customer;
import com.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CheckerController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    CheckerService checkerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //customer details and Home page
    @RequestMapping(value = "/checker")
    public ModelAndView listCustomer(ModelAndView model) {
        List<Customer> customer = this.customerDao.getCustomer();
        model.addObject("customer", customer);
        model.setViewName("checkerView/checker");
        return model;
    }

    @RequestMapping("approve{customerCode}")
    public String approve(@PathVariable("customerCode") String customerCode, Model model) {
        try {
            Customer customer = customerDao.getCustomerByCode(customerCode);
            CustomerDTO checkerDTO = checkerService.CustomerToDto(customer);

            if (customer.getRecordStatus().equals("N")) {
                customerDao.approve(customerCode);

            }

            if (customer.getRecordStatus().equals("M")) {
                checkerDTO.setRecordStatus("A");
                checkerDTO.setAuthorizedDate(Date.valueOf(LocalDate.now()));
                checkerDTO.setAuthorizedBy("checker");
                customerDao.getUpdate(checkerDTO);

            }
            if(customer.getRecordStatus().equals("A")) {
                throw new Exception();
            }

            model.addAttribute("customer", checkerDTO);
            return "checkerView/approveSuccess";
        }
        catch(Exception e) {
            return "/checkerView/errorChecker";
        }
    }

    @RequestMapping("/approveSuccess")
    public String approveSuccess(Model model) {
        model.addAttribute("customer",new CustomerDTO());
        return "checkerView/approveSuccess";
    }

    @RequestMapping("reject{customerCode}")
    public RedirectView deleteCustomer(@PathVariable("customerCode") String customerCode, HttpServletRequest request){
        Customer customerTemp = customerDao.getCustomerByCode(customerCode);
        CustomerDTO checkerDTO = checkerService.CustomerToDto(customerTemp);
        if (customerTemp.getRecordStatus().equals("A") || customerTemp.getRecordStatus().equals("N") || customerTemp.getRecordStatus().equals("M")) {
            checkerDTO.setRecordStatus("D");
        }
        customerDao.getUpdate(checkerDTO);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/checker");
        return redirectView;
    }
}
