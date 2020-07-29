package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MostAbundant implements OrderingStrategy {
    @Override
    public List<StockDTO> getFromStock(OrderDTO orderDTO, StockRepository stockRepository) throws Exception {

        List<SimplifiedProductDTO> simplifiedProductDTOS = orderDTO.getProducts();

        List<StockDTO> validStocks=new ArrayList<>();

        AtomicBoolean valid = new AtomicBoolean(true);

        simplifiedProductDTOS.forEach((n)->{
            Stock s =stockRepository.getMaxQuantity(n.getID());
            if(s.getQuantity() >= n.getQuantity()){
                validStocks.add(new StockDTO(s.getStockID().getLocationID(),n.getID(),n.getQuantity()));
            }
            else{
                valid.set(false);
            }
        });

        if(valid.get()) {
            return validStocks;
        }else {
            throw new Exception("No Set of Locations Found");
        }
    }
}
