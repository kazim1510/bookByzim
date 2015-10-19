/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Membership;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.*;


/**
 *
 * @author HP
 */
@Default
@Stateless
public class MembershipJPABean implements MembershipDAO{
    
    @PersistenceContext
    private EntityManager em;
    
    
    public void loadData(){
        Membership free = new Membership();
        free.setSubsType("free");
        free.setPricePerMonth(0);
        
        Membership standard = new Membership();
        standard.setSubsType("standerd");
        standard.setPricePerMonth(10);
        
        Membership premium = new Membership();
        premium.setSubsType("premium");
        premium.setPricePerMonth(20);
    }

    @Override
    public Membership get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Membership subscription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
