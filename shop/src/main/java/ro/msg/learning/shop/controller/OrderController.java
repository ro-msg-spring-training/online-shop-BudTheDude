package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.service.OrderService;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String order(@RequestBody OrderDTO orderDTO) throws Exception {

        orderService.order(orderDTO);
        return "Ordered";
    }


}
