package org.example.Restaurant.Management.System.Repository;

import jakarta.transaction.Transactional;
import org.example.Restaurant.Management.System.Model.Orders;
import org.example.Restaurant.Management.System.Model.Status;
import org.example.Restaurant.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrdersRepo extends JpaRepository<Orders, Integer> {
    List<Orders> findByUser(User user);


    @Transactional
    @Modifying
    @Query(value = "UPDATE ORDERS SET ORDERS_STATUS = :status WHERE ORDERS_ID = :id", nativeQuery = true)
    void setStatus(Integer id, Status status);
}
