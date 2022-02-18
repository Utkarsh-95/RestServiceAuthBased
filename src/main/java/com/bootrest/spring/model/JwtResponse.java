package com.bootrest.spring.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private final String key;

	public JwtResponse(String jwttoken) {
		this.key = jwttoken;

	}

	public String getKey() {
		return key;
	}

}