package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
