package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory getByID(int id){
        return productCategoryRepository.findById(id).get();
    };
}
