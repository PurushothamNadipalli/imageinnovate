package com.imaginnovate.imaginnovateAppilication.customAnnotations;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

// Define the PhoneValidator class
public class DateValidator implements ConstraintValidator<ValidDate, String> {
	 private Boolean isOptional;

	    @Override
	    public void initialize(ValidDate validDate) {
	        this.isOptional = validDate.optional();
	    }

	    @Override
	    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(false); // Set lenient to false to strictly parse the date
	        
	        try {
	            sdf.parse(value);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	    
	    }

	    
}