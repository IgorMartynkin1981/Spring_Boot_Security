package ru.martynkin.security.services;

import ru.martynkin.security.dto.UserRegistration;
import ru.martynkin.security.dto.UserInfo;

public interface AdministratorService {

    UserInfo createUser(UserRegistration userRegistration);

}
