package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.repositories.StockRepository;

public class MostAbundant implements OrderingStrategy {
    @Override
    public Order getFromStock(OrderDTO orderDTO, StockRepository stockRepository) {

        return null;
    }
}
