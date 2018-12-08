package ru.study.shitty_project.service;

import ru.study.shitty_project.module.User;
import ru.study.shitty_project.utill.exception.NotFoundException;

import java.util.Collection;

public interface UserService {
    User save(User user);
    void delete(long id) throws NotFoundException;
    User get(long id);
    Collection<User> getAll();
}
