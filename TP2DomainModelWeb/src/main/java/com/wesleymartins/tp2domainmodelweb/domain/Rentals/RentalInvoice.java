/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wesleymartins.tp2domainmodelweb.domain.Rentals;

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
public class RentalInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
private String dateRented;
    private String dateReturned;

    public String getId() {
        return id;
    }

    public String getDateRented() {
        return dateRented;
    }

    public String getDateReturned() {
        return dateReturned;
    }
    
        private RentalInvoice(){}
    
        
 private RentalInvoice(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private String id;
            private String dateRented;
            
            public Builder(String id)
            {
                this.id = id;
            }
                        
        
        
        public Builder dateRented(String value)
        {
            dateRented = value;
            return this;
        }
        
        public RentalInvoice build()
        {
        return new RentalInvoice(this);
        }
    
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
        if (!(object instanceof RentalInvoice)) {
            return false;
        }
        RentalInvoice other = (RentalInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Rentals.RentalInvoice[ id=" + id + " ]";
    }
    
}
