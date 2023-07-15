package org.example.Restaurant.Management.System.Controller;

import jakarta.validation.Valid;
import org.example.Restaurant.Management.System.Model.User;
import org.example.Restaurant.Management.System.Model.dto.SignInInput;
import org.example.Restaurant.Management.System.Model.dto.SignUpOutput;
import org.example.Restaurant.Management.System.Service.AuthenticationService;
import org.example.Restaurant.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    //User Sign Up
    @PostMapping("userSignUp")
    public SignUpOutput signUpUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }

    //User Sign In
    @PostMapping("userSignIn")
    public String userSignIn(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.userSignIn(signInInput);
    }

    //User Sign Out
    @DeleteMapping("userSignOut")
    public String userSignOut(String email, String token)
    {
        if(authenticationService.authenticate(email, token))
        {
            return userService.userSignOut(email);
        }
        else {
            return "Sign out not allowed for non authenticated user";
        }
    }
}
