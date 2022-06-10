package com.bbtutorials.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
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
}
