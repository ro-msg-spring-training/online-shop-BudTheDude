package ro.msg.learning.shop.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimplifiedProductDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.embeddedid.StockID;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.strategy.SingleLocation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SingleLocationTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private SingleLocation singleLocation;

    @BeforeEach
    void initUseCase() {
        singleLocation = new SingleLocation();
    }

    @Test
    void foundCorrectLocations() throws Exception {
        Stock stock11 = new Stock(new StockID(1,1),null,null,30);
        Stock stock21 = new Stock(new StockID(2,1),null,null,40);

        Stock stock12 = new Stock(new StockID(1,2),null,null,25);
        Stock stock22 = new Stock(new StockID(2,2),null,null,80);

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock11);
        stocks.add(stock12);
        stocks.add(stock21);
        stocks.add(stock22);

        SimplifiedProductDTO simplifiedProductDTO = new SimplifiedProductDTO(1,20);
        SimplifiedProductDTO simplifiedProductDTO2 = new SimplifiedProductDTO(2,60);

        List<SimplifiedProductDTO> list = new ArrayList<>();
        list.add(simplifiedProductDTO);
        list.add(simplifiedProductDTO2);

        when(stockRepository.findAll()).thenReturn(stocks);

        OrderDTO orderDTO = new OrderDTO("10-06-2020",1,"Romania","Baia Mare","MM","Malinului 12",list);

        StockDTO stockDTO1 = new StockDTO(2,1,20);
        StockDTO stockDTO2 = new StockDTO(2,2,60);
        List<StockDTO> expectedResult = new ArrayList<>();
        expectedResult.add(stockDTO1);
        expectedResult.add(stockDTO2);


        List<StockDTO> foundStocks= singleLocation.getFromStock(orderDTO,stockRepository);

        assertEquals(foundStocks,expectedResult);


    }
}
