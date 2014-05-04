/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.services;

import com.wesleymartins.tp2domainmodelweb.domain.rentals.Rentee;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface RenteeTelephoneService {
    
    public List<Rentee> getRenteeTelephone(String i);
}
