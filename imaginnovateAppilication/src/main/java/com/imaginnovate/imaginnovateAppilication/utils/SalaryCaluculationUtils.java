package com.imaginnovate.imaginnovateAppilication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.imaginnovate.imaginnovateAppilication.model.Employee;

public class SalaryCaluculationUtils {

	public static boolean validatePhoneNumbers(Employee employee) {
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		for(String phone:employee.getPhoneNumber()) {
	   
		Matcher match = ptrn.matcher(phone);  
		if(!(match.find() && match.group().equals(phone))) {
			return false;
		}
		}
		return true;
	}
	
	
	public static boolean validateEmail(Employee employee) {
		
		 Pattern VALID_EMAIL_ADDRESS_REGEX =    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(employee.getEmail());
		 return matcher.matches();
	}
	
	public static String getStringDate(Date doj) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String dateString = df.format(doj);
		return dateString;
	}
}
