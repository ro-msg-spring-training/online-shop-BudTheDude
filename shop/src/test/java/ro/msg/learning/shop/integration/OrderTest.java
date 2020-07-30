package ro.msg.learning.shop.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.entity.Order;
import ro.msg.learning.shop.service.OrderService;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@Transactional
@SpringBootTest
class OrderTest {


    @Autowired
    private OrderService orderService;

    @Test
    void testOrder() throws Exception {

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

        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        Statement statement = conn.createStatement();
        statement.execute(query);

        SimplifiedProductDTO simplifiedProductDTO = new SimplifiedProductDTO(1, 10);
        SimplifiedProductDTO simplifiedProductDTO2 = new SimplifiedProductDTO(2, 20);

        List<SimplifiedProductDTO> list = new ArrayList<>();
        list.add(simplifiedProductDTO);
        list.add(simplifiedProductDTO2);

        OrderDTO orderDTO = new OrderDTO("10-06-2020", 1, "Romania", "Baia Mare", "MM", "Malinului 12", list);

        Order order = orderService.order(orderDTO);

        assertEquals(order.getCreatedAt(),orderDTO.getTimeStamp());

    }

}
