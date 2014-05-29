/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.presentation.rest;
import com.wesleymartins.tp2domainmodelweb.domain.customer.Customer;
import com.wesleymartins.tp2domainmodelweb.services.CustomerAgeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Wesley
 */
@Controller  // Annotation to make this class be detectable by the config as a controller
@RequestMapping(value = "api/customer")
public class CustomerAgeRestController {
    
    @Autowired
    private CustomerAgeService customerService;
    
    @RequestMapping(value = "create",method = RequestMethod.PUT) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody Customer customer) { // @RequestBody for converting incoming JSON call to Object
        customerService.persist(customer);
        
        System.out.println(" Create the Called ");
        return "RegularCustomer Created";
    }
    
    
    @RequestMapping(value = "name/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public List<Customer> getByName(@PathVariable int i){
        List<Customer> customer = customerService.getAgeAbove(i);
        if(customer != null){
            return customer;
        }
        
        return null;
    }
    
    @RequestMapping(value = "regularcustomers",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Customer> getCustomers() {
        System.out.println("All Customers");
        return customerService.findAll();
    }
}