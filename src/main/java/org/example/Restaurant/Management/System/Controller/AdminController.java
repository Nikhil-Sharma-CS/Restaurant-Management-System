package org.example.Restaurant.Management.System.Controller;

import jakarta.validation.Valid;
import org.example.Restaurant.Management.System.Model.Admin;
import org.example.Restaurant.Management.System.Model.User;
import org.example.Restaurant.Management.System.Model.dto.SignInInput;
import org.example.Restaurant.Management.System.Model.dto.SignUpOutput;
import org.example.Restaurant.Management.System.Service.AdminService;
import org.example.Restaurant.Management.System.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    
    @Autowired
    AdminService adminService;


    @Autowired
    AuthenticationService authenticationService;

    //User Sign Up
    @PostMapping("adminSignUp")
    public SignUpOutput signUpAdmin(@RequestBody Admin admin)
    {
        return adminService.signUpAdmin(admin);
    }

    //User Sign In
    @PostMapping("adminSignIn")
    public String adminSignIn(@RequestBody @Valid SignInInput signInInput)
    {
        return adminService.adminSignIn(signInInput);
    }

    //User Sign Out
    @DeleteMapping("adminSignOut")
    public String adminSignOut(String email, String token)
    {
        if(authenticationService.authenticateAdmin(email, token))
        {
            return adminService.adminSignOut(email);
        }
        else {
            return "Sign out not allowed for non authenticated Admin";
        }
    }
}
