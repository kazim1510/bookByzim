
package com.bookstore.DB;

import com.bookstore.model.Account;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * Account bean interface  for providing CRUD access to accounts.
 * @author HP
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
     */
    public Account update(Account account);
     /**
     * change user password.
     * @param account
     */
    public void updatePassword(Account account);
     /**
     * delete user account.
     * @param account
     */
    public void delete(Account account);
     /**
     * Retrieve a list of all accounts.
     * 
     * @return the list of accounts
     */
    public List<Account> getList();
}
