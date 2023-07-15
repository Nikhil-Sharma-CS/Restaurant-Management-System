package org.example.Restaurant.Management.System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersId;

    private Integer ordersQuantity;

    @Enumerated(EnumType.STRING)
    private Status ordersStatus;

    //User should be connected
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    User user;

    //FoodItem should be connected
    @ManyToOne
    @JoinColumn(name = "fk_food_id")
    FoodItem foodItem;

}
