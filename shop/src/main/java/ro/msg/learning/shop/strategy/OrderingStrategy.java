package ro.msg.learning.shop.strategy;


import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.List;

public interface OrderingStrategy {

    List<StockDTO> getFromStock(OrderDTO orderDTO, StockRepository stockRepository) throws Exception;
}
