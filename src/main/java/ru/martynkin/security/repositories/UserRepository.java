package ru.martynkin.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.martynkin.security.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
