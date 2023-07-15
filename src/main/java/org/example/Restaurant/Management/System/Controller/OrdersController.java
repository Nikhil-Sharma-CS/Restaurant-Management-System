package org.example.Restaurant.Management.System.Controller;

import jakarta.validation.Valid;
import org.example.Restaurant.Management.System.Model.Orders;
import org.example.Restaurant.Management.System.Model.Status;
import org.example.Restaurant.Management.System.Model.User;
import org.example.Restaurant.Management.System.Service.AdminService;
import org.example.Restaurant.Management.System.Service.AuthenticationService;
import org.example.Restaurant.Management.System.Service.OrdersService;
import org.example.Restaurant.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AdminService adminService;

    //Add Orders
    @PostMapping("addOrder")
    String addOrders(@RequestBody Orders order, String token, String email)   //This will take order with token value
    {
        if(!authenticationService.authenticate(email, token)) {
            return "Authentication Failed";
        }

        return   ordersService.addOrders(order);
    }

    //Delete Order
    @DeleteMapping("deleteOrder/{Id}")
    String deleteOrder(@PathVariable Integer Id, String token, String email)
    {
        if(!authenticationService.authenticate(email, token)) {
            return "Authentication Failed";
        }

        return ordersService.deleteOrder(Id);
    }

    @GetMapping("seeOrders/{id}")
    List<Orders> seeOrders(@PathVariable Integer id, String token, String email)
    {
        if(!authenticationService.authenticate(email, token)) {
            return null;
        }

        return ordersService.seeOrder(id, email);
    }

    //Only admins can do this
    @PutMapping("editOrderStatus/{orderId}")
    String editOrder(@PathVariable Integer orderId, @RequestParam Status status, String email)
    {
        if(adminService.checkValid(email) != null)
        {
            return ordersService.editOrderStatus(orderId, status);
        }

        return "Admin not valid";
    }
}
