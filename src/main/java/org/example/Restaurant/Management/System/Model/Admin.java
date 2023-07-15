package org.example.Restaurant.Management.System.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    private String adminName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@admin\\.com$")
    private String adminEmail;

    private String adminPassword;

    //Admin shall have a list of foodItems
    @OneToMany
    @JoinColumn(name = "fk_admin_id")
    List<FoodItem> foodItemList;

    //Admin can see all users
    @OneToMany
    @JoinColumn(name = "fk_admin_id")
    List<User> users;
}
