package ru.study.shitty_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.study.shitty_project.module.User;
import ru.study.shitty_project.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public Collection<User> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{userId}")
    public User get(@PathVariable(value = "userId") Long id){
        return service.get(id);
    }

    @DeleteMapping(value = "/{userId}")
    public void delete(@PathVariable(value = "userId") Long id) {
        service.delete(id);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return service.save(user);
    }
}
