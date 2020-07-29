package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;

@Service
@AllArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;


    public ProductCategory getByID(int id){
        return productCategoryRepository.findById(id).get();
    };
}
