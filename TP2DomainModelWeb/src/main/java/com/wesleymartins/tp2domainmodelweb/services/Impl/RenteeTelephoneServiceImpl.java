/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services.Impl;

import com.wesleymartins.tp2domainmodelweb.domain.rentals.Rentee;
import com.wesleymartins.tp2domainmodelweb.repository.RenteeRepository;
import com.wesleymartins.tp2domainmodelweb.services.RenteeTelephoneService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author Wesley
*/
@Service
public class RenteeTelephoneServiceImpl implements RenteeTelephoneService{

    @Autowired
    private RenteeRepository accessoryRepository;
    
    
    public List<Rentee> getRenteeTelephone(String i) {
       List<Rentee> rentee = new ArrayList<>();
        List<Rentee> allRentees =accessoryRepository.findAll();

        for (Rentee person : allRentees) {
            if (person.getTel() == i) {
                rentee.add(person);
            }
        }
        return rentee;
    
        
    }
    
}