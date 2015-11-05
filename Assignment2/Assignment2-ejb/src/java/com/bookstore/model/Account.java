/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * A model object for user accounts, storing their username, password,
 * full name, email, date of birth, subscription month and subscription type.
 * 
 * @author kazim and bipin
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
    private int submonth = 1;
    private Date startdate;
    private Date enddate;
    private String groupname;
    private int isLogin = 0;
    private int version =0;
    
    public Account(String username, String password, String Fullname, String email, Date dob, String subscription, int submonth, Date startdate, Date enddate,String groupname, int isLogin) {
        this.username = username;
        this.password = password;
        this.Fullname = Fullname;
        this.email = email;
        this.dob = dob;
        this.subscription = subscription;
        this.submonth = submonth;
        this.startdate = new Date();
        this.enddate = enddate;
        this.groupname=groupname;
        this.isLogin = isLogin;
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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
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

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }
    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
  
}
