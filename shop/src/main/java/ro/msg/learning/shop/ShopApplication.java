package ro.msg.learning.shop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@SpringBootApplication
public class ShopApplication  {


	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);

	}


}