package ro.msg.learning.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.SupplierRepository;
import ro.msg.learning.shop.service.OrderService;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ActiveProfiles("test")
@Transactional
@SpringBootTest
class ShopApplicationTests{


	@Autowired
	private OrderService orderService;

	@Test
	void contextLoads() throws Exception {

		SimplifiedProductDTO simplifiedProductDTO = new SimplifiedProductDTO(1,10);
		SimplifiedProductDTO simplifiedProductDTO2 = new SimplifiedProductDTO(2,20);

		List<SimplifiedProductDTO> list = new ArrayList<>();
		list.add(simplifiedProductDTO);
		list.add(simplifiedProductDTO2);

		OrderDTO orderDTO = new OrderDTO("10-06-2020",1,"Romania","Baia Mare","MM","Malinului 12",list);

		Order order = orderService.order(orderDTO);


	}

}
