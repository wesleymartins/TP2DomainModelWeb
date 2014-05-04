/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.TP2DomainModelWeb.test.services;

import com.wesleymartins.tp2domainmodelweb.app.config.ConnectionConfig;
import com.wesleymartins.tp2domainmodelweb.domain.staff.Manager;
import com.wesleymartins.tp2domainmodelweb.repository.ManagerRepository;
import com.wesleymartins.tp2domainmodelweb.services.ManagerSalaryService;
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
public class testManagerSalaryService {
    
    private static ApplicationContext ctx;
    private ManagerSalaryService customerSalaryService;
    private ManagerRepository customerRepository;
    
    public testManagerSalaryService() {
    }

    @Test
    public void getSalaryingofManager() {
        customerRepository = ctx.getBean(ManagerRepository.class);
        customerSalaryService = ctx.getBean(ManagerSalaryService.class);
        
        Manager c1 = new Manager.Builder("Gerald")           
                .build();
        Manager c2 = new Manager.Builder("Wesley")
                .build();
        Manager c3 = new Manager.Builder("Brandon")
                .build();

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);

        List<Manager> people = customerSalaryService.getManagerSalary(2000.00);

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
       customerRepository = ctx.getBean(ManagerRepository.class);
       customerRepository.deleteAll();
    }
}