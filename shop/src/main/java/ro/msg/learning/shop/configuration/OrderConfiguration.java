package ro.msg.learning.shop.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ro.msg.learning.shop.strategy.MostAbundant;
import ro.msg.learning.shop.strategy.OrderingStrategy;
import ro.msg.learning.shop.strategy.SingleLocation;


@Configuration
@AllArgsConstructor
public class OrderConfiguration {


    private final Environment env;

    @Bean
    public OrderingStrategy orderingStrategy() {
        String strategy = env.getProperty("selectedStrategy");
        if ("SingleLocation".equals(strategy)) {
            return new SingleLocation();
        } else {
            return new MostAbundant();
        }
    }
}
