package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class SingleLocation implements OrderingStrategy {
    @Override
    public List<StockDTO> getFromStock(OrderDTO orderDTO, StockRepository stockRepository) throws Exception {
        List<Stock> stocks= stockRepository.findAll();
        List<SimplifiedProductDTO> simplifiedProductDTOS = orderDTO.getProducts();
        Set<Integer> locationIDs = new HashSet<>();
        stocks.forEach((n) -> locationIDs.add(n.getStockID().getLocationID()));


        for(Integer n : locationIDs){
            List<Stock> candidate = stocks.stream().
                    filter(m->m.getStockID().getLocationID()==n).
                    collect(Collectors.toList());

            AtomicBoolean valid = new AtomicBoolean(true);

            List<StockDTO> validStocks = new ArrayList<>();

            simplifiedProductDTOS.forEach((p)->{
                Optional<Stock> optional =candidate.stream().filter((c)->
                    c.getStockID().getProductID() == p.getID() && c.getQuantity() >= p.getQuantity()
                ).findAny();


                if(optional.isEmpty()){
                    valid.set(false);
                }else{
                    validStocks.add(new StockDTO(optional.get().getStockID().getLocationID(),p.getID(),p.getQuantity()));
                }

            });

            if(valid.get()){
                return validStocks;
            }
        };

        throw new Exception("No Set of Locations Found");
    }
}
