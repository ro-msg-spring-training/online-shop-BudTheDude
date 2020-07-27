package ro.msg.learning.shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.strategy.OrderingStrategy;
import ro.msg.learning.shop.strategy.SingleLocation;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderingStrategy orderingStrategy(){
        return new SingleLocation();
    }
}
