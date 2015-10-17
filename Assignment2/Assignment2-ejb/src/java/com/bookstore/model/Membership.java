/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bookstore.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author HP
 */
@Entity
public class Membership implements Serializable{
   
    private String subsId;
    private String subsType;
    private int pricePerMonth;

    public Membership(String subsId, String subsType, int pricePerMonth) {
        this.subsId = subsId;
        this.subsType = subsType;
        this.pricePerMonth = pricePerMonth;
    }

    public Membership() {
    }

    @Id
    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }
    
    public String getSubsType() {
        return subsType;
    }

    public void setSubsType(String subsType) {
        this.subsType = subsType;
    }
    public int getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }
}
