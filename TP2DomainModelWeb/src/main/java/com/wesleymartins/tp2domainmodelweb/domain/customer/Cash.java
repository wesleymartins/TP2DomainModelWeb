/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.domain.customer;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Wesley
 */
@Entity
public class Cash implements Serializable, Payment {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public Cash() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private double cashTendered;
    private double itemPrice;
    
    public double calcAmount() {
        
        return itemPrice;
    }

    public double getCashTendered() {
        return cashTendered;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    
    
    
        
 private Cash(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private String id;
            private double cashTendered;
            
            public Builder(String id)
            {
                this.id = id;
            }
                        
        
        
        public Builder cashTendered(double value)
        {
            cashTendered = value;
            return this;
        }
        
        public Cash build()
        {
        return new Cash(this);
        }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cash)) {
            return false;
        }
        Cash other = (Cash) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Customer.Cash[ id=" + id + " ]";
    }
    
}
        
}
