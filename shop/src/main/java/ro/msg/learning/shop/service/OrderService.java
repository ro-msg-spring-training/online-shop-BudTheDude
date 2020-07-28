package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Customer;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.CustomerRepository;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.OrderRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.OrderingStrategy;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderingStrategy orderingStrategy;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    LocationRepository locationRepository;

    public Order order(OrderDTO orderDTO) throws Exception {

        List<StockDTO> foundLocations = orderingStrategy.getFromStock(orderDTO,stockRepository);

        Order order = new Order();

        Customer customer = customerRepository.findById(orderDTO.getCustomerID()).get();

        //Put 1 for location, as it was not specified how we should handle this field
        Location location = locationRepository.findById(1).get();

        order.setShippedFrom(location);
        order.setCustomer(customer);
        order.setCreatedAt(orderDTO.getTimeStamp());
        order.setCountry(orderDTO.getCountry());
        order.setCity(orderDTO.getCity());
        order.setCounty(orderDTO.getCounty());
        order.setStreetAddress(orderDTO.getStreetAddress());

        orderRepository.save(order);

        foundLocations.forEach((n)->{
           Stock s = stockRepository.findByProductAndAndLocation(n.getProductID(),n.getLocationID());
           int newQuantity = s.getQuantity() - n.getQuantity();
           s.setQuantity(newQuantity);
           stockRepository.save(s);

        });

        return order;
    }
}
