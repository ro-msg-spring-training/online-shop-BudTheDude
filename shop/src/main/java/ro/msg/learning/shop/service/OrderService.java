package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.repositories.*;
import ro.msg.learning.shop.strategy.OrderingStrategy;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderingStrategy orderingStrategy;

    private final StockRepository stockRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    private final LocationRepository locationRepository;


    public Order order(OrderDTO orderDTO) throws Exception {

        List<StockDTO> foundLocations = orderingStrategy.getFromStock(orderDTO, stockRepository);

        Order order = new Order();

        Customer customer = customerRepository.findById(orderDTO.getCustomerID()).orElse(null);

        //Put 1 for location, as it was not specified how we should handle this field
        Location location = locationRepository.findById(1).orElse(null);

        order.setShippedFrom(location);
        order.setCustomer(customer);
        order.setCreatedAt(orderDTO.getTimeStamp());
        order.setCountry(orderDTO.getCountry());
        order.setCity(orderDTO.getCity());
        order.setCounty(orderDTO.getCounty());
        order.setStreetAddress(orderDTO.getStreetAddress());

        orderRepository.save(order);

        foundLocations.forEach((foundLoc) -> {
            Stock stock = stockRepository.findByProductAndLocation(foundLoc.getProductID(), foundLoc.getLocationID());
            int orderQuantity = foundLoc.getQuantity();
            int newQuantity = stock.getQuantity() - orderQuantity;


            stock.setQuantity(newQuantity);
            stockRepository.save(stock);

        });

        return order;
    }
}
