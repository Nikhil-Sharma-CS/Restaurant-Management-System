package org.example.Restaurant.Management.System.Service;

import org.example.Restaurant.Management.System.Model.Orders;
import org.example.Restaurant.Management.System.Model.Status;
import org.example.Restaurant.Management.System.Model.User;
import org.example.Restaurant.Management.System.Repository.IOrdersRepo;
import org.example.Restaurant.Management.System.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    IOrdersRepo iOrdersRepo;

    @Autowired
    IUserRepo iUserRepo;
    public String addOrders(Orders orders) {

        if(orders.getFoodItem() == null)
            return "Food Item Does Not exist";

        iOrdersRepo.save(orders);
        return "Order Saved";
    }

    public String deleteOrder(Integer Id) {

        if (iOrdersRepo.existsById(Id)) {
            iOrdersRepo.deleteById(Id);
            return "Order deleted";
        }
        return "Order Can't be deleted";
    }

    public List<Orders> seeOrder(Integer id, String email) {

        User user = iUserRepo.findById(id).orElse(null);

        if(user == null)
            return null;
        if(user.getUserEmail().equals(email))
            return iOrdersRepo.findByUser(user);
        return  null;
    }

    public String editOrderStatus(Integer id, Status status) {

        Orders order = iOrdersRepo.findById(id).orElse(null);

        if(order != null)
        {
            iOrdersRepo.setStatus(id, status);
            return "Order Status Updated";
        }

        return "Order by Id does not exists";
    }
}
