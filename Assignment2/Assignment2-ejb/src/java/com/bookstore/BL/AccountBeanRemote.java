
package com.bookstore.BL;

import com.bookstore.model.Account;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * Account bean interface  for providing CRUD access to accounts.
 * @author kazim and bipin
 */
@Remote
public interface AccountBeanRemote extends Serializable{
     /**
     * create user account.
     * @param account
     */
    public void create(Account account);
     /**
     * get user account detail.
     * @param username.
     * @return account
     */
    public Account get(String username);
     /**
     * delete user account.
     * @param account
     * @return account
     */
    public Account update(Account account);
     /**
     * change user password.
     * @param account 
     * @param password
     */
    public void updatePassword(Account account,String password);
      /**
     * Update value of isLogin, which is used to check user is already
     * logged or not.
     * @param account 
     */
    public void updateLogin(Account account);
      /**
     * get the value of isLogin.
     * @param id 
     * @return value of isLogin 0 or 1.
     */
    public int getisLoginvalue(String id);
     /**
     * delete user account.
     * @param account
     */
    public void delete(Account account);
     /**
     * Retrieve a list of all accounts.
     * @return the list of accounts
     */
    public List<Account> getList();
}
