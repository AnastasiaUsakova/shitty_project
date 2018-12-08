package ru.study.shitty_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.study.shitty_project.module.User;
import ru.study.shitty_project.repositories.UserRepository;
import ru.study.shitty_project.service.UserService;
import ru.study.shitty_project.utill.exception.NotFoundException;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (!repository.delete(id)){
            throw new NotFoundException();
        }
    }

    @Override
    public User get(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return repository.getAll();
    }
}
