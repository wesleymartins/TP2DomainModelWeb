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
public class StorePurchase implements Serializable, Transaction {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
  private String time;

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }
    
     private StorePurchase(){}
    
        
 private StorePurchase(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private String id;
            private String time;
            
            public Builder(String id)
            {
                this.id = id;
            }
                        
        
        
        public Builder time(String value)
        {
            time = value;
            return this;
        }
        
        public StorePurchase build()
        {
        return new StorePurchase(this);
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
        if (!(object instanceof StorePurchase)) {
            return false;
        }
        StorePurchase other = (StorePurchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Customer.StorePurchase[ id=" + id + " ]";
    }
    
}
        
}
