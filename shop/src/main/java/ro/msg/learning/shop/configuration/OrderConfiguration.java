package ro.msg.learning.shop.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ro.msg.learning.shop.strategy.MostAbundant;
import ro.msg.learning.shop.strategy.OrderingStrategy;
import ro.msg.learning.shop.strategy.SingleLocation;

import java.util.Objects;


@Configuration
@AllArgsConstructor
public class OrderConfiguration {

    private final static Integer SingleLocation = 1;

    private final Environment env;

    @Bean
    public OrderingStrategy orderingStrategy(){
            int strategy = Integer.parseInt(Objects.requireNonNull(env.getProperty("selectedStrategy")));
            if(strategy == SingleLocation)
                return new SingleLocation();
            else
                return new MostAbundant();
    }
}
