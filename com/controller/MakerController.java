package com.controller;

import com.model.dao.CustomerDao;
import com.model.dto.CustomerDTO;
import com.model.entity.Customer;
import com.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MakerController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    MakerService makerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //customer form
    @RequestMapping(value = "customer")
    public String customerForm(@ModelAttribute("customer") CustomerDTO makerDTO, Model model) {
        model.addAttribute("customer", makerDTO);
        return "/makerView/customer";
    }

    //add the customer
    @RequestMapping(value = "success", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("customer") CustomerDTO makerDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return "makerView/customer";
            }
            else {
                makerDTO.setCustomerId(this.customerDao.maxCustomerId());
                makerDTO.setCreatedBy("Maker");
                makerDTO.setCreateDate(Date.valueOf(LocalDate.now()));
                makerDTO.setRecordStatus("N");
                this.customerDao.getSave(makerDTO);
                return "makerView/success";
            }
        } catch(Exception e) {
            return "makerView/errorMaker";
        }
    }

    //update form
    @RequestMapping(value = "update{customerCode}")
    public String updateForm(@ModelAttribute("customer") CustomerDTO makerDTO, @PathVariable("customerCode") String customerCode, Model model) {
        Customer customer = customerDao.getCustomerByCode(customerCode);
        makerDTO = makerService.CustomerToDto(customer);
        model.addAttribute("customer", makerDTO);
        return "/makerView/update";
    }

    @RequestMapping(value = "update")
    public String updateForm(@ModelAttribute("customer") CustomerDTO makerDTO, Model model) {
        model.addAttribute("customer", makerDTO);
        return "/makerView/update";
    }


    //update the customer
    @RequestMapping(value = "updateSuccess", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("customer") CustomerDTO makerDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "makerView/customer";
        }

        Customer customer = customerDao.getCustomerByCode(makerDTO.getCustomerCode());

        if(customer.getRecordStatus().equals("N") || customer.getRecordStatus().equals("D")) {

            makerDTO.setCustomerId(this.customerDao.maxCustomerId());
            makerDTO.setCreatedBy("Maker");
            makerDTO.setCreateDate(Date.valueOf(LocalDate.now()));
            makerDTO.setModifiedDate(Date.valueOf(LocalDate.now()));
            makerDTO.setModifiedBy("Maker");
            makerDTO.setRecordStatus("M");
            makerDTO.setModifiedBy("Maker");
            makerDTO.setModifiedDate(Date.valueOf(LocalDate.now()));
            this.customerDao.getUpdate(makerDTO);
        }

        if(customer.getRecordStatus().equals("A") || customer.getRecordStatus().equals("M")) {
            makerDTO.setCustomerId(this.customerDao.maxCustomerId());
            makerDTO.setCreatedBy("Maker");
            makerDTO.setCreateDate(Date.valueOf(LocalDate.now()));
            makerDTO.setModifiedDate(Date.valueOf(LocalDate.now()));
            makerDTO.setModifiedBy("Maker");
            makerDTO.setRecordStatus("M");
            makerDTO.setModifiedBy("Maker");
            makerDTO.setModifiedDate(Date.valueOf(LocalDate.now()));
            this.customerDao.getUpdate(makerDTO);
        }
            return "makerView/updateSuccess";
    }

    //delete the record
    @RequestMapping("/deleteCustomer/{customerCode}")
    public RedirectView deleteCustomer(@PathVariable("customerCode") String customerCode, HttpServletRequest request){
        Customer customerTemp = this.customerDao.getCustomerByCode(customerCode);
        if (customerTemp.getRecordStatus().equals("N") || customerTemp.getRecordStatus().equals("M") || customerTemp.getRecordStatus().equals("A") || customerTemp.getRecordStatus().equals("D")) {
            this.customerDao.deleteCustomer(customerCode);
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/maker");
        return redirectView;
    }

    //customer details and Home page
    @RequestMapping(value = "maker")
    public ModelAndView listCustomer(ModelAndView model) {
        List<Customer> customer = this.customerDao.getCustomer();
        model.addObject("customer", customer);
        model.setViewName("makerView/maker");
        return model;
    }
}
