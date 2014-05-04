/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services.Impl;

/**
 *
 * @author Wesley
 */
import com.wesleymartins.tp2domainmodelweb.domain.customer.Customer;
import com.wesleymartins.tp2domainmodelweb.repository.CustomerRepository;
import com.wesleymartins.tp2domainmodelweb.services.CustomerAgeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Wesley
*/
@Service
public class CustomerAgeServiceImpl implements CustomerAgeService{

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public List<Customer> getAgeAbove(int i) {
       List<Customer> cust = new ArrayList<>();
        List<Customer> allCustomers =customerRepository.findAll();

        for (Customer person : allCustomers) {
            if (person.getAge() > i) {
                cust.add(person);
            }
        }
        return cust;
    
        
    }
    
}
