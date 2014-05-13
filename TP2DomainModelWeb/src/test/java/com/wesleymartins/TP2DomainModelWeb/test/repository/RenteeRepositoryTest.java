/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.repository;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.rentals.Rentee;
import com.wesleymartins.tp2domainmodelweb.repository.RenteeRepository;
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
public class RenteeRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private RenteeRepository repo;
    
    public RenteeRepositoryTest() {
    }

    @Test
     public void createRentee() {
         repo = ctx.getBean(RenteeRepository.class);
         Rentee p = new Rentee.Builder("Wesley").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
     }
     
     @Test(dependsOnMethods = "createRentee")
     public void readRentee(){
         repo = ctx.getBean(RenteeRepository.class);
         Rentee person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Wesley");
         
     }
     
    @Test(dependsOnMethods = "readRentee")
     private void updateRentee(){
         repo = ctx.getBean(RenteeRepository.class);
         Rentee person = repo.findOne(id);
         Rentee updatedRentee = new Rentee.Builder("Wesley").build();
        
         repo.save(updatedRentee);
         
         Assert.assertEquals(updatedRentee.getName(), "Wesley");
         
     }
     
    @Test(dependsOnMethods = "updateRentee")
     private void deleteRentee(){
         repo = ctx.getBean(RenteeRepository.class);
         Rentee person = repo.findOne(id);
         repo.delete(person);
         
         Rentee deletedRentee = repo.findOne(id);
         
         Assert.assertNull(deletedRentee);
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