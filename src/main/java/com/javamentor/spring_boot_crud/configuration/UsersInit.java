package com.javamentor.spring_boot_crud.configuration;

import com.javamentor.spring_boot_crud.models.Role;
import com.javamentor.spring_boot_crud.models.User;
import com.javamentor.spring_boot_crud.services.RoleServiceImpl;
import com.javamentor.spring_boot_crud.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UsersInit {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;


    @PostConstruct
    private void loadTestUsers() {

        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        adminRole.setDescription("Admin can delete update add new");
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName("USER");
        userRole.setDescription("User can only view ");
        roleService.add(userRole);

        Set<Role> roles = new HashSet<>();
        User userAdmin = new User("Владимир", "Некрасов", "nve4@admin.ru", (byte) 35, "admin", "admin");
        roles.add(userRole);
        roles.add(adminRole);
        userAdmin.setRoles(roles);
        userService.add(userAdmin);

        roles.clear();
        User user1 = new User("Иван", "Иванов", "ivan@user.ru", (byte) 32, "user", "user");
        roles.add(userRole);
        user1.setRoles(roles);
        userService.add(user1);

        roles.clear();
        User user2 = new User("Петр", "Иванов", "petr@user.ru", (byte) 27, "user1", "user1");
        roles.add(userRole);
        user2.setRoles(roles);
        userService.add(user2);

        roles.clear();
        User user3 = new User("Сергей", "Петров", "admin1@admin.ru", (byte) 25, "admin1", "admin1");
        roles.add(adminRole);
        user3.setRoles(roles);
        userService.add(user3);
    }
}