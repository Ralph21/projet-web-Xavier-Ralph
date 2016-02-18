package com.miage.services;

import com.miage.domain.User_roles;

public interface User_rolesService {
    Iterable<User_roles> listAllRole();

    User_roles getRoleById(Integer id);

    User_roles saveRole(User_roles user_roles);
}
