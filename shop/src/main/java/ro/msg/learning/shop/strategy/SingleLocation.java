package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class SingleLocation implements OrderingStrategy {
    @Override
    public Order getFromStock(OrderDTO orderDTO, StockRepository stockRepository) {
        List<Stock> stocks= stockRepository.findAll();
        List<SimplifiedProductDTO> simplifiedProductDTOS = orderDTO.getProducts();
        Set<Integer> locationIDs = new HashSet<>();
        stocks.forEach((n) -> locationIDs.add(n.getStockID().getLocationID()));


        List<Order> orders = new ArrayList<>();

        locationIDs.forEach((n)->{
            List<Stock> candidate = stocks.stream().
                    filter(m->m.getStockID().getLocationID()==n).
                    collect(Collectors.toList());

            AtomicBoolean valid = new AtomicBoolean(true);

            simplifiedProductDTOS.forEach((p)->{
                Optional<Stock> optional =candidate.stream().filter((c)->
                    c.getStockID().getProductID() == p.getID() && c.getQuantity() >= p.getQuantity()
                ).findAny();


                if(optional.isEmpty()){
                    valid.set(false);
                }

            });

            if(valid.get()){
                candidate.forEach((o)->System.out.println(o.getStockID() + " " + o.getQuantity()));
            }


        });

        return null;
    }
}
