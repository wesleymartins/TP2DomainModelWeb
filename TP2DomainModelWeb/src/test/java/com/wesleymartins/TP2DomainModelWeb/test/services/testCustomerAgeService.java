/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.services;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.customer.Customer;
import com.wesleymartins.tp2domainmodelweb.repository.CustomerRepository;
import com.wesleymartins.tp2domainmodelweb.services.CustomerAgeService;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Wesley
 */
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
*
* @author wesley
*/
public class testCustomerAgeService {
    
    private static ApplicationContext ctx;
    private CustomerAgeService customerAgeService;
    private CustomerRepository customerRepository;
    
    public testCustomerAgeService() {
    }

    @Test
    public void getAgeingofCustomer() {
        customerRepository = ctx.getBean(CustomerRepository.class);
        customerAgeService = ctx.getBean(CustomerAgeService.class);
        
        Customer c1 = new Customer.Builder("Wesley").age(21)          
                .build();
        Customer c2 = new Customer.Builder("Martins").age(18)
                .build();
        Customer c3 = new Customer.Builder("Sarah").age(25)
                .build();

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        List<Customer> people = customerAgeService.getAgeAbove(21);

        Assert.assertEquals(people.size(), 1);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       customerRepository = ctx.getBean(CustomerRepository.class);
       customerRepository.deleteAll();
    }
}