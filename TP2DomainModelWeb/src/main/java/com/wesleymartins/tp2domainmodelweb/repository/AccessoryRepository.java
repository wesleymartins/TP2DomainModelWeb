/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.repository;

import com.wesleymartins.tp2domainmodelweb.domain.items.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wesley
 */
@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long>{
    
}