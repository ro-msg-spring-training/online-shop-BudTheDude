package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.repositories.StockRepository;

public interface OrderingStrategy {

    public Order getFromStock(OrderDTO orderDTO,StockRepository stockRepository);
}
