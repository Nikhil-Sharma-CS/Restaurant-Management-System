package org.example.Restaurant.Management.System.Service;

import org.example.Restaurant.Management.System.Model.AuthenticationToken;
import org.example.Restaurant.Management.System.Repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthTokenRepo authTokenRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

    public boolean authenticateAdmin(String email, String token) {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(token);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getAdmin().getAdminEmail();

        return tokenConnectedEmail.equals(email);
    }
}
