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
public class Credit implements Serializable, Payment {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
 private double itemPrice;
    private String type;

    public double calcAmount() {
        
        return itemPrice;
    }

    public String getId() {
        return id;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getType() {
        return type;
    }
    
    private Credit(){}
    
        
 private Credit(Builder builder){
     id = builder.id;
     
 }
 
 
        public static class Builder
        {
            private String id;
            private String type;
            
            public Builder(String id)
            {
                this.id = id;
            }
                        
        
        
        public Builder type(String value)
        {
            type = value;
            return this;
        }
        
        public Credit build()
        {
        return new Credit(this);
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
        if (!(object instanceof Credit)) {
            return false;
        }
        Credit other = (Credit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesleymartins.tp2domainmodelweb.domain.Customer.Credit[ id=" + id + " ]";
    }
    
}
        
}
