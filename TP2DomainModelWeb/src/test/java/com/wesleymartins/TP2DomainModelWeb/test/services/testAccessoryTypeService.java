/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.services;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.items.Accessory;
import com.wesleymartins.tp2domainmodelweb.repository.AccessoryRepository;
import com.wesleymartins.tp2domainmodelweb.services.AccessoryTypeService;
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
public class testAccessoryTypeService {
    
    private static ApplicationContext ctx;
    private AccessoryTypeService customerTypeService;
    private AccessoryRepository customerRepository;
    
    public testAccessoryTypeService() {
    }

    @Test
    public void getTypeingofAccessory() {
        customerRepository = ctx.getBean(AccessoryRepository.class);
        customerTypeService = ctx.getBean(AccessoryTypeService.class);
        
        Accessory c1 = new Accessory.Builder("RazerV1204")           
                .build();
        Accessory c2 = new Accessory.Builder("Alienware223")
                .build();
        Accessory c3 = new Accessory.Builder("Geforce Mouse")
                .build();

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        List<Accessory> people = customerTypeService.getAccessoryType("Headset");

        Assert.assertEquals(people.size(), 2);

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
       customerRepository = ctx.getBean(AccessoryRepository.class);
       customerRepository.deleteAll();
    }
}