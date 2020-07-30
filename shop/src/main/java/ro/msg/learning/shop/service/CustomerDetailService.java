package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repositories.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerDetailService {

    private final CustomerRepository customerRepository;

}
