package org.example.Restaurant.Management.System.Repository;


import org.example.Restaurant.Management.System.Model.Admin;
import org.example.Restaurant.Management.System.Model.AuthenticationToken;
import org.example.Restaurant.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByAdmin(Admin admin);
}
