/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services;

import com.wesleymartins.tp2domainmodelweb.domain.customer.Customer;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface CustomerAgeService extends Services <Customer, Long>{
    
    public List<Customer> getAgeAbove(int i);

    

    public List<Customer> findAll();

    
}
