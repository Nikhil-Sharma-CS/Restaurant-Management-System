package org.example.Restaurant.Management.System.Service;

import org.example.Restaurant.Management.System.Model.Admin;
import org.example.Restaurant.Management.System.Model.AuthenticationToken;
import org.example.Restaurant.Management.System.Model.dto.SignInInput;
import org.example.Restaurant.Management.System.Model.dto.SignUpOutput;
import org.example.Restaurant.Management.System.Repository.IAdminRepo;
import org.example.Restaurant.Management.System.Repository.IAuthTokenRepo;
import org.example.Restaurant.Management.System.Service.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    IAdminRepo iAdminRepo;

    @Autowired
    IAuthTokenRepo iAuthTokenRepo;

    public Admin checkValid(String email) {

        return iAdminRepo.findByadminEmail(email);
    }

    public SignUpOutput signUpAdmin(Admin admin) {
        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = admin.getAdminEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this patient email already exists ??
        Admin existingPatient = iAdminRepo.findFirstByAdminEmail(newEmail);

        if(existingPatient != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());

            //saveAppointment the patient with the new encrypted password

            admin.setAdminPassword(encryptedPassword);
            iAdminRepo.save(admin);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String adminSignIn(SignInInput signInInput) {
        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this patient email already exists ??
        Admin existingAdmin = iAdminRepo.findFirstByAdminEmail(signInEmail);

        if(existingAdmin == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingAdmin.getAdminPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingAdmin);
                iAuthTokenRepo.save(authToken);


                return authToken.getTokenValue() + " - This is your token";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }

    public String adminSignOut(String email) {
        Admin admin = iAdminRepo.findFirstByAdminEmail(email);
        iAuthTokenRepo.delete(iAuthTokenRepo.findFirstByAdmin(admin));
        return "Signed Out Successfully";
    }
}
