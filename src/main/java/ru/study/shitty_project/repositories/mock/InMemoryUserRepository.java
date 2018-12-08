package ru.study.shitty_project.repositories.mock;

import org.springframework.stereotype.Repository;
import ru.study.shitty_project.module.User;
import ru.study.shitty_project.repositories.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private static long sequence = 1L;

    private final static Map<Long, User> data = new HashMap<>();

    static {
        data.put(sequence, new User(sequence++, "admin", "admin"));
        data.put(sequence, new User(sequence++, "user", "user"));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(sequence++);
        }
        return data.put(user.getId(), user);
    }

    @Override
    public boolean delete(long id) {
        return (data.remove(id) != null);
    }

    @Override
    public User get(long id) {
        return data.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return data.values();
    }
}
