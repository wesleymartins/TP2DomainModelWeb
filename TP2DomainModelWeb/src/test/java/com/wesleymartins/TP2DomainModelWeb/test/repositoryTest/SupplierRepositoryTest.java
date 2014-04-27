/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.repositoryTest;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.other.Supplier;
import com.wesleymartins.tp2domainmodelweb.repository.SupplierRepository;
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
public class SupplierRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private SupplierRepository repo;
    
    public SupplierRepositoryTest() {
    }

    @Test
     public void createSupplier() {
         repo = ctx.getBean(SupplierRepository.class);
         Supplier p = new Supplier.Builder("Wesley").build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);
     }
     
     @Test(dependsOnMethods = "createSupplier")
     public void readSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier person = repo.findOne(id);
         Assert.assertEquals(person.getName(), "Martins");
         
     }
     
    @Test(dependsOnMethods = "readSupplier")
     private void updateSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier person = repo.findOne(id);
         Supplier updatedSupplier = new Supplier.Builder("Wesley").build();
        
         repo.save(updatedSupplier);
         
         Assert.assertEquals(updatedSupplier.getName(), "Martins");
         
     }
     
    @Test(dependsOnMethods = "updateSupplier")
     private void deleteSupplier(){
         repo = ctx.getBean(SupplierRepository.class);
         Supplier person = repo.findOne(id);
         repo.delete(person);
         
         Supplier deletedSupplier = repo.findOne(id);
         
         Assert.assertNull(deletedSupplier);
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