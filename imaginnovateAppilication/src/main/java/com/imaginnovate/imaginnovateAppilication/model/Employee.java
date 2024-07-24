package com.imaginnovate.imaginnovateAppilication.model;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@NotBlank
	private String email;
	@NotBlank
	private Set<String> phoneNumber;
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date  doj;
	@NotBlank
	private double salary;
	
	
}
