package ro.msg.learning.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.embedded_IDs.StockID;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.MostAbundant;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MostAbundantTest {

    @Mock
    private StockRepository stockRepository;

    private MostAbundant mostAbundant;

    @BeforeEach
    void initUseCase() {
        mostAbundant = new MostAbundant();
    }

    @Test
    void foundCorrectLocations() throws Exception {
        Stock stock11 = new Stock(new StockID(1,1),null,null,30);
        Stock stock21 = new Stock(new StockID(2,1),null,null,40);

        Stock stock12 = new Stock(new StockID(1,2),null,null,25);
        Stock stock22 = new Stock(new StockID(2,2),null,null,80);

        Stock max1;

        if(stock11.getQuantity()>stock12.getQuantity()){
            max1 = stock11;
        }else{
            max1 = stock12;
        }

        Stock max2;

        if(stock21.getQuantity()>stock22.getQuantity()){
            max2 = stock21;
        }else{
            max2 = stock22;
        }


        SimplifiedProductDTO simplifiedProductDTO = new SimplifiedProductDTO(1,20);
        SimplifiedProductDTO simplifiedProductDTO2 = new SimplifiedProductDTO(2,60);

        List<SimplifiedProductDTO> list = new ArrayList<>();
        list.add(simplifiedProductDTO);
        list.add(simplifiedProductDTO2);

        when(stockRepository.getMaxQuantity(1)).thenReturn(max1);
        when(stockRepository.getMaxQuantity(2)).thenReturn(max2);

        OrderDTO orderDTO = new OrderDTO("10-06-2020",1,"Romania","Baia Mare","MM","Malinului 12",list);

        StockDTO stockDTO1 = new StockDTO(1,1,20);
        StockDTO stockDTO2 = new StockDTO(2,2,60);
        List<StockDTO> expectedResult = new ArrayList<>();
        expectedResult.add(stockDTO1);
        expectedResult.add(stockDTO2);

        List<StockDTO> foundStocks= mostAbundant.getFromStock(orderDTO,stockRepository);

        assertEquals(foundStocks,expectedResult);

    }
}
