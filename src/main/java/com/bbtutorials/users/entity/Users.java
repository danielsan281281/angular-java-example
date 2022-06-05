package com.bbtutorials.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	@Column
    private long id;

    @Column
    @NotNull(message="{NotNull.Users.firstName}")
    private String firstName;
    
    @Column
    @NotNull(message="{NotNull.Users.lastName}")
    private String lastName;
    
    @Column
    @NotNull(message="{NotNull.Users.email}")
    private String email;

    public Users(){
    }

    // Only for testing purposes
    public Users(long id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
