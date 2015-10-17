/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.MembershipDAO;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author HP
 */
public class MembershipController implements Serializable{
    
    @Inject
    private MembershipDAO membershipDAO;
    
    
}
