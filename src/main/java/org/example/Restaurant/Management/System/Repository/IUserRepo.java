package org.example.Restaurant.Management.System.Repository;

import org.example.Restaurant.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByUserEmail(String newEmail);
}
