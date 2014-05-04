/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.repository;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.items.Accessory;
import com.wesleymartins.tp2domainmodelweb.repository.AccessoryRepository;
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
public class AccessoryRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AccessoryRepository repo;
    
    public AccessoryRepositoryTest() {
    }

    @Test
     public void createAccessory() {
         repo = ctx.getBean(AccessoryRepository.class);
         Accessory p = new Accessory.Builder("Controller").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
     }
     
     @Test(dependsOnMethods = "createAccessory")
     public void readAccessory(){
         repo = ctx.getBean(AccessoryRepository.class);
         Accessory person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "DualShock4");
         
     }
     
    @Test(dependsOnMethods = "readAccessory")
     private void updateAccessory(){
         repo = ctx.getBean(AccessoryRepository.class);
         Accessory person = repo.findOne(id);
         Accessory updatedAccessory = new Accessory.Builder("Contoller").build();
        
         repo.save(updatedAccessory);
         
         Assert.assertEquals(updatedAccessory.getName(), "DualShock4");
         
     }
     
    @Test(dependsOnMethods = "updateAccessory")
     private void deleteAccessory(){
         repo = ctx.getBean(AccessoryRepository.class);
         Accessory person = repo.findOne(id);
         repo.delete(person);
         
         Accessory deletedAccessory = repo.findOne(id);
         
         Assert.assertNull(deletedAccessory);
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