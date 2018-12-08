package ru.study.shitty_project.repositories;

import ru.study.shitty_project.module.User;

import java.util.Collection;

public interface UserRepository {

    User save(User user);
    boolean delete(long id);
    User get(long id);
    Collection<User> getAll();

}
