package com.bbtutorials.users.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbtutorials.users.dto.UsersDTO;
import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.UserLinks;
import com.bbtutorials.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UsersService usersService;

    @GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<List<UsersDTO>> listUsers() {
        log.info("UsersController:  listUsers");

        List<UsersDTO> resource = usersService.getUsers().stream().map(users -> modelMapper.map(users, UsersDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = UserLinks.ADD_USER)
    public ResponseEntity<UsersDTO> saveUser(@RequestBody UsersDTO userDTO) {
        log.info("UsersController: saveUser");

        // DTO to entity
        Users user = modelMapper.map(userDTO, Users.class);

        user = usersService.saveUser(user);

        // entity to DTO
        UsersDTO resource = modelMapper.map(user, UsersDTO.class);

        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = UserLinks.GET_USER)
    public ResponseEntity<UsersDTO> getUser(@PathVariable long id) {
        log.info("UsersController: getUser");

        Users user = usersService.getUser(id);

        // entity to DTO
        UsersDTO resource = modelMapper.map(user, UsersDTO.class);

        return ResponseEntity.ok(resource);
    }
}
