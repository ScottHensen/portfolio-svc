package com.scotthensen.portfolio.svc.portfolio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "security")
@NoArgsConstructor
@AllArgsConstructor
public class Security {

	@Id
	@GeneratedValue
	private Long id;
	
	private String security;

}
