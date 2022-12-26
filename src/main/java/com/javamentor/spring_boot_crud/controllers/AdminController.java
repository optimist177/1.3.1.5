package com.javamentor.spring_boot_crud.controllers;

import com.javamentor.spring_boot_crud.models.User;
import com.javamentor.spring_boot_crud.services.RoleService;
import com.javamentor.spring_boot_crud.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin")
    public String printWelcome(@ModelAttribute("user") User user, Principal principal, ModelMap model) {
        if (principal != null) {
            model.addAttribute("currentUser", userService.getByName(principal.getName()));
        }
        model.addAttribute("usersList", userService.getAll());
        model.addAttribute("rolesList", roleService.getAll());
        return "index";
    }
//    @GetMapping(value = "/user")
//    public String userprintWelcome(@ModelAttribute("user") User user, Principal principal, ModelMap model) {
//        if (principal != null) {
//            model.addAttribute("currentUser", userService.getByName(principal.getName()));
//        }
//        model.addAttribute("usersList", userService.getAll());
//        model.addAttribute("rolesList", roleService.getAll());
//        return "/user";
//    }

}