package org.example.Restaurant.Management.System.Repository;

import org.example.Restaurant.Management.System.Model.Admin;
import org.example.Restaurant.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo  extends JpaRepository<Admin, Integer> {
    Admin findByadminEmail(String email);

    Admin findFirstByAdminEmail(String newEmail);
}
