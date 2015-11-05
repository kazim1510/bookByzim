package com.bookstore.utility;

import javax.ejb.*;

/**
 * This exception is thrown if the user attempts to update a record that has
 * been modified concurrently. 
 * When the exception occurs, the transaction will be rolled back so that no 
 * changes are saved to the database.
 */
@ApplicationException(rollback = true)
public class ConcurrentChangeDetected extends Exception {
    
}
