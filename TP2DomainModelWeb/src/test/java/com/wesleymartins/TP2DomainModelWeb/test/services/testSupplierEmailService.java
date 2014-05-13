/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.services;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.other.Supplier;
import com.wesleymartins.tp2domainmodelweb.repository.SupplierRepository;
import com.wesleymartins.tp2domainmodelweb.services.SupplierEmailService;
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
public class testSupplierEmailService {
    
    private static ApplicationContext ctx;
    private SupplierEmailService customerEmailService;
    private SupplierRepository customerRepository;
    
    public testSupplierEmailService() {
    }

    @Test
    public void getEmailingofSupplier() {
        customerRepository = ctx.getBean(SupplierRepository.class);
        customerEmailService = ctx.getBean(SupplierEmailService.class);
        
        Supplier c1 = new Supplier.Builder("BT Games")        
                .build();
        Supplier c2 = new Supplier.Builder("Musica")
                .build();
        Supplier c3 = new Supplier.Builder("Ster Kinekor")
                .build();

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        List<Supplier> people = customerEmailService.getSupplierEmail("BT Games");

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
       customerRepository = ctx.getBean(SupplierRepository.class);
       customerRepository.deleteAll();
    }
}