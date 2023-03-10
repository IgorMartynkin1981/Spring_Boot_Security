package ru.martynkin.security.dto;

import ru.martynkin.security.entity.User;

public class UserMapper {

    public static User toUser(UserRegistration userRegistration) {
        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setFirstName(userRegistration.getFirstName());
        user.setLastName(userRegistration.getLastName());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(userRegistration.getPassword());
        user.setRoles(userRegistration.getRoles());

        return user;
    }

    public static UserInfo toUserInfo(User user) {
        UserInfo userInfo = new UserInfo();

        if (user.getId() != null) userInfo.setId(user.getId());

        userInfo.setUsername(user.getUsername());
        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setEmail(user.getEmail());

        return userInfo;
    }
}
