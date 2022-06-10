package com.bbtutorials.users.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsersDTO implements Serializable {

	private long id;
    private String firstName;
    private String lastName;
    private String email;
}
