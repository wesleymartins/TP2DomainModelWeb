/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.repositoryTest;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.staff.Manager;
import com.wesleymartins.tp2domainmodelweb.repository.ManagerRepository;
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
public class ManagerRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ManagerRepository repo;
    
    public ManagerRepositoryTest() {
    }

    @Test
     public void createManager() {
         repo = ctx.getBean(ManagerRepository.class);
         Manager p = new Manager.Builder("Wesley").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
     }
     
     @Test(dependsOnMethods = "createManager")
     public void readManager(){
         repo = ctx.getBean(ManagerRepository.class);
         Manager person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Martins");
         
     }
     
    @Test(dependsOnMethods = "readManager")
     private void updateManager(){
         repo = ctx.getBean(ManagerRepository.class);
         Manager person = repo.findOne(id);
         Manager updatedManager = new Manager.Builder("Wesley").build();
        
         repo.save(updatedManager);
         
         Assert.assertEquals(updatedManager.getName(), "Martins");
         
     }
     
    @Test(dependsOnMethods = "updateManager")
     private void deleteManager(){
         repo = ctx.getBean(ManagerRepository.class);
         Manager person = repo.findOne(id);
         repo.delete(person);
         
         Manager deletedManager = repo.findOne(id);
         
         Assert.assertNull(deletedManager);
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