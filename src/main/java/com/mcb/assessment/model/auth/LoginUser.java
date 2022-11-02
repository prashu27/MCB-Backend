package com.mcb.assessment.model.auth;

import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class LoginUser {

	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "name cannot be null")
	@Length(min = 3)
	private String username;
	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "name cannot be null")
	@Length(min = 10)
	private String password;

	public String getUsername () {
		return username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}
}