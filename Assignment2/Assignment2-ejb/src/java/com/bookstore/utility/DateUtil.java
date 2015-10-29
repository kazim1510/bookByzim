/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.utility;

import java.util.Calendar;

/**
 * utility class for show expired date.
 * @author bipinpatel
 */
public class DateUtil {
       public static java.util.Date addMonths(java.util.Date dateValue, int months){

		Calendar calendar = Calendar.getInstance();		
		calendar.setTime(dateValue);
		calendar.add(Calendar.MONTH, + months);
		dateValue = calendar.getTime();
		return  dateValue;
	}
    
}
