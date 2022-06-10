package com.bbtutorials.users.links;

import org.springframework.stereotype.Component;

@Component
public final class UserLinks {
	
	public static final String LIST_USERS = "/users";
    public static final String ADD_USER = "/user";
    public static final String GET_USER = "/user/{id}";

}
