/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;


/**
 * A model object for user accounts, storing their username, password,
 * full name, email, date of birth, subscription month and subscription type.
 * 
 * @author HP
 */
@XmlRootElement
@Entity
public class Account implements Serializable{
    
    
    private String username;
    private String password;
    private String Fullname;
    private String email;   
    private Date dob;
    private String subscription;
    private int submonth;
    private Date startdate;
    private Date enddate;
    private String role;
    
    public Account(String username, String password, String Fullname, String email, Date dob, String subscription, int submonth, Date startdate, Date enddate,String role) {
        this.username = username;
        this.password = password;
        this.Fullname = Fullname;
        this.email = email;
        this.dob = dob;
        this.subscription = subscription;
        this.submonth = submonth;
        this.startdate = new Date();
        this.enddate = enddate;
        this.role=role;
       
    }
    public Account() {
    }

    @Id
   
    public String getUsername() {
        return username;
    }
    
    @Temporal(TemporalType.DATE)
   
    public Date getDob() {
        return dob;
    }

     public void setDob(Date dob) {
        this.dob = dob;
    }
     
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }


    public String getSubscription() {
        return subscription;
    }

   public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public int getSubmonth() {
        return submonth;
    }

    public void setSubmonth(int submonth) {
        this.submonth = submonth;
    }
    @Temporal(TemporalType.DATE)
    public Date getStartdate() {
        return startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    @Temporal(TemporalType.DATE)
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    
  
}
