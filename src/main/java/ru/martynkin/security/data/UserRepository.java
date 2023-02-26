package ru.martynkin.security.data;

import org.springframework.data.repository.CrudRepository;
import ru.martynkin.security.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
