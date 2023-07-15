package org.example.Restaurant.Management.System.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$")
    private String userEmail;

    private String userPassword;


//    //Users can see list of food items
//    @OneToMany
//    @JoinColumn(name = "fk_user_id")
//    List<FoodItem> foodItems;


}
