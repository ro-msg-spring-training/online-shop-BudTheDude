package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.OrderingStrategy;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderingStrategy orderingStrategy;
    @Autowired
    StockRepository stockRepository;

    public void order(){
        List<SimplifiedProductDTO> list= new ArrayList<>();
        list.add(new SimplifiedProductDTO(1,2));
        list.add(new SimplifiedProductDTO(2,90));
        
        OrderDTO orderDTO = new OrderDTO("","","","","",list);
        orderingStrategy.getFromStock(orderDTO,stockRepository);
    }
}
