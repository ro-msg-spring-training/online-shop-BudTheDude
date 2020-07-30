package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.service.OrderService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@RestController
@Profile("test")
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {


    private final OrderService orderService;

    @PostMapping("/populate")
    public String populate() throws SQLException {
        String query = "insert into supplier values(1,'Comat');\n" +
                "insert into product_category values(1,'Laptops','Best');\n" +
                "insert into product values(1,'Asus','good',2000,4,1,1,'');\n" +
                "insert into product values(2,'Dell','good',2000,4,1,1,'');\n" +
                "insert into customer values(1,'Bogdan','Bud','budb','parola','@');\n" +
                "insert into location values(1,'Dedeman','RO','BM','MM','Victoriei');\n" +
                "insert into location values(2,'Metro','RO','BM','MM','Victoriei');\n" +
                "insert into stock values(1,1,40);\n" +
                "insert into stock values(1,2,10);\n" +
                "insert into stock values(2,1,20);\n" +
                "insert into stock values(2,2,80);";

        Connection conn = DriverManager.getConnection ("jdbc:h2:mem:test", "sa","");
        Statement statement = conn.createStatement();
        statement.execute(query);
        return "Success";
    }

    @PostMapping("/clear")
    public String test() throws SQLException {
        String query = "DELETE FROM order1;\n" +
                "DELETE FROM stock;\n" +
                "DELETE FROM customer;\n" +
                "DELETE FROM product;\n" +
                "DELETE FROM product_Category;\n" +
                "DELETE FROM supplier;\n" +
                "DELETE FROM orderDetail;\n" +
                "DELETE FROM location;\n" +
                "DELETE FROM revenue;";
        Connection conn = DriverManager.getConnection ("jdbc:h2:mem:test", "sa","");
        Statement statement = conn.createStatement();
        statement.execute(query);
        return "Success";
    }

    @PostMapping("/order")
    public Order order(@RequestBody OrderDTO orderDTO) throws Exception {

        return orderService.order(orderDTO);

    }


}
