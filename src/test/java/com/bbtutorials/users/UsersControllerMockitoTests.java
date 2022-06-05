package com.bbtutorials.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.bbtutorials.users.controller.UsersController;
import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.service.UsersService;

@ExtendWith(MockitoExtension.class)
public class UsersControllerMockitoTests {

    @Mock
    UsersService usersService;

    @InjectMocks
    UsersController usersController;

    @Test
    public void testGetUser() throws Exception {
        Users user = new Users(1, "first", "last 1", "abc1@gmail.com");

        Mockito.when(usersService.getUser(1)).thenReturn(user);

        ResponseEntity<Users> responseEntity = usersController.getUser(1);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

}