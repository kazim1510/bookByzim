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
public class Subscription implements Serializable{
   
    private int subsId;
    private String subsType;
    private Date startDate;
    private Date endDate;
    private int pricePerMonth;

    public Subscription(int subsId, String subsType, Date startDate, Date endDate, int pricePerMonth) {
        this.subsId = subsId;
        this.subsType = subsType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerMonth = pricePerMonth;
    }

    public Subscription() {
    }

    
    @Id
    @GeneratedValue
    public int getSubsId() {
        return subsId;
    }

    public void setSubsId(int subsId) {
        this.subsId = subsId;
    }

    public String getSubsType() {
        return subsType;
    }

    public void setSubsType(String subsType) {
        this.subsType = subsType;
    }

@Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

@Temporal(TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }
}
