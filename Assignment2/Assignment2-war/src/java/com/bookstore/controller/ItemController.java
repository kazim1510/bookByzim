/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.ItemBeanRemote;
import com.bookstore.model.Item;
import com.bookstore.utility.ConcurrentChangeDetected;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * This backing bean manages request for upload new book and get list of books.
 *  and Delete books
 * @author kazim
 */
@Named
@RequestScoped
public class ItemController implements Serializable{
    
    @EJB
    ItemBeanRemote itemremote;

    public Item getItem() {
        return item;
    }
     public void setItem(Item item) {
        this.item = item;
    }
   private Item item=new Item();
 
    /**
     * Method for upload new book.
     * @return
     * 
     */
    public String createItem(){
        try{
      item.setItemId(null);
      itemremote.create(item);
      return "/Admin/listitem?faces-redirect=true";
        }catch(Exception e){
            showError("Check your Input");
            return null;
        }
     }
    /**
     * get the list of books.
     * @param username
     * @return list of books.
     * 
     */
    public List<Item> listItem(String username){
        try{
        return itemremote.getList(username);
        } catch (Exception e){
            showError("Check your Input");
            return null;
        }
    }
    /**
     * get the list of Item.
     * @return list of items.
     * 
     */
    public List<Item> listAll(){
        try{
        return itemremote.getAllList();
        } catch (Exception e){
            showError("Check your Input");
            return null;
        }
    }
    
    /**
     * Delete Item.
     * @param itemId
     * @return
     */
    public String deleteItem(String itemId){
        try{
        itemremote.delete(itemId);
        return "/Admin/listitem?faces-redirect=true";
        } catch (Exception e){
            showError("Check your Input");
            return null;
        }
    }
     /**
     * Update Item.
     * @param item
     * @return
     */
    public String updateItem(Item item)
    {   
        try{
            item= itemremote.updateItem(item);
            return "/Admin/listitem?faces-redirect=true";
        }
        catch(ConcurrentChangeDetected c){
            item = itemremote.getItem(item.getItemId());
            showError("Item could not be updated because another user has changed the record. Please try again.");
            return null;
        }
    }
    
    private void showError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
}
