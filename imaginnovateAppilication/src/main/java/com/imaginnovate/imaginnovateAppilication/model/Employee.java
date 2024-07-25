package com.imaginnovate.imaginnovateAppilication.model;

import java.util.Date;
import java.util.Set;

import com.imaginnovate.imaginnovateAppilication.customAnnotations.ValidDate;
import com.imaginnovate.imaginnovateAppilication.customAnnotations.ValidEmail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@ValidEmail
	private String email;
	
	@NotEmpty@Size(min = 1, message = "Phone numbers  must not be empty")
	private Set<@NotEmpty@Size(min = 10, max = 10) String> phoneNumber;
	
	@ValidDate
	private Date  doj;
	
	@NotNull(message = "salary cannot be null")@DecimalMin(value = "0.0", inclusive = true, message = "salary must be at least 0.0")
	private Double salary;

	
	
}
