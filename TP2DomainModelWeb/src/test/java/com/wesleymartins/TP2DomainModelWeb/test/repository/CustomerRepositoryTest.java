/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.repository;

import com.wesleymartins.tp2domainmodelweb.domain.customer.Customer;
import com.wesleymartins.tp2domainmodelweb.repository.CustomerRepository;
import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
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
 * @author Wesley
 */
public class CustomerRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private CustomerRepository repo;
    
    public CustomerRepositoryTest() {
    }

    @Test
     public void createCustomer() {
         repo = ctx.getBean(CustomerRepository.class);
         Customer p = new Customer.Builder("Wesley").age(21).surname("Martins").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
     }
     
     @Test(dependsOnMethods = "createCustomer")
     public void readCustomer(){
         repo = ctx.getBean(CustomerRepository.class);
         Customer person = repo.findOne(id);
         Assert.assertEquals(person.getfName(), "Wesley");
         
     }
     
    @Test(dependsOnMethods = "readCustomer")
     private void updateCustomer(){
         repo = ctx.getBean(CustomerRepository.class);
         Customer person = repo.findOne(id);
         Customer updatedCustomer =  new Customer.Builder("Wesley").age(21).surname("Martins").build();
        
         repo.save(updatedCustomer);
         
         Assert.assertEquals(updatedCustomer.getfName(), "Wesley");
         
     }
     
    @Test(dependsOnMethods = "updateCustomer")
     private void deleteCustomer(){
         repo = ctx.getBean(CustomerRepository.class);
         Customer person = repo.findOne(id);
         repo.delete(person);
         
         Customer deletedCustomer = repo.findOne(id);
         
         Assert.assertNull(deletedCustomer);
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
    }
}