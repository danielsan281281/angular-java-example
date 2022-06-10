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
    void testGetUser() throws Exception {

        Users user = Users.builder().id(1).firstName("first").lastName("last 1").email("abc1@gmail.com").build();

        Mockito.when(usersService.getUser(1)).thenReturn(user);

        ResponseEntity<Users> responseEntity = usersController.getUser(1);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}