/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Membership;
import java.io.Serializable;
import javax.ejb.Remote;

/**
 *
 * @author HP
 */
@Remote
public interface MembershipDAO extends Serializable{
 
    public Membership get(int id);
    
    public void update(Membership subscription);
}
