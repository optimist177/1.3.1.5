package com.javamentor.spring_boot_crud.services;

import com.javamentor.spring_boot_crud.models.Role;
import com.javamentor.spring_boot_crud.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void add(Role role) {
        List<Role> roles = getAll();
        if (!roles.contains(role)) {
            role.setRoleName("ROLE_" + role.getRoleName());
            roleRepository.save(role);
        }
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

}
