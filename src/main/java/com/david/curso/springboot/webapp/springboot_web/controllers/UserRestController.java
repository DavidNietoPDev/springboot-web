package com.david.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.curso.springboot.webapp.springboot_web.models.User;
import com.david.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {


    @GetMapping(path= "/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("David", "Nieto");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring boot");
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("David", "Nieto");
        User user2 = new User("Pedro", "Rodríguez");
        User user3 = new User("Kratos", "Dios");

        List<User> users = Arrays.asList(user, user2, user3);

        // List<User> users = new ArrayList<>();      Otra forma de hacerlo
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }


    @GetMapping(path= "/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("David", "Nieto");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola mundo Spring boot");
        body.put("user", user);
        return body;
    }


}
