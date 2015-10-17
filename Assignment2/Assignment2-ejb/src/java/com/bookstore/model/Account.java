/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.model;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author HP
 */
@Entity
public class Account {
    
    private String username;
    private String password;
    
    private String Fullname;
    
    @Id
    public String getUsername() {
        return username;
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

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date dateofBirth;
    
    
    
    
}
