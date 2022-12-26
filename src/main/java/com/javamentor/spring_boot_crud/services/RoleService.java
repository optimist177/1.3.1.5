package com.javamentor.spring_boot_crud.services;

import com.javamentor.spring_boot_crud.models.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);

    List<Role> getAll();
}

