package ru.martynkin.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.martynkin.security.dto.UserInfo;
import ru.martynkin.security.dto.UserMapper;
import ru.martynkin.security.dto.UserRegistration;
import ru.martynkin.security.entity.Role;
import ru.martynkin.security.entity.User;
import ru.martynkin.security.repositories.RoleRepository;
import ru.martynkin.security.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdministratorServiceImpl(UserRepository userRepository,
                                    RoleRepository roleRepository,
                                    PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserInfo createUser(UserRegistration userRegistration) {
        findByUsername(userRegistration.getUsername());

        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        userRegistration.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        userRegistration.setRoles(userRoles);

        return UserMapper.toUserInfo(userRepository.save(UserMapper.toUser(userRegistration)));
    }

    private void findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new UsernameNotFoundException(String
                    .format("a user with the same name {} already exists", user.getUsername()));
        }
    }
}
