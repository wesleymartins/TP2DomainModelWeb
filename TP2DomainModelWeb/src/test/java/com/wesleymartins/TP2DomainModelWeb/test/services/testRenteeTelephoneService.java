/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.services;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.rentals.Rentee;
import com.wesleymartins.tp2domainmodelweb.repository.RenteeRepository;
import com.wesleymartins.tp2domainmodelweb.services.RenteeTelephoneService;
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
public class testRenteeTelephoneService {
    
    private static ApplicationContext ctx;
    private RenteeTelephoneService customerTelephoneService;
    private RenteeRepository customerRepository;
    
    public testRenteeTelephoneService() {
    }

    @Test
    public void getTelephoneingofRentee() {
        customerRepository = ctx.getBean(RenteeRepository.class);
        customerTelephoneService = ctx.getBean(RenteeTelephoneService.class);
        
        Rentee c1 = new Rentee.Builder("Tamsin Weer").t("0843975423")       
                .build();
        Rentee c2 = new Rentee.Builder("Grant Muller").t("0217134536")
                .build();
        Rentee c3 = new Rentee.Builder("Maxwell Adams").t("0216542314")
                .build();

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        List<Rentee> people = customerTelephoneService.getRenteeTelephone("0217134536");

        Assert.assertEquals(people.size(), 0);

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
       customerRepository = ctx.getBean(RenteeRepository.class);
       customerRepository.deleteAll();
    }
}