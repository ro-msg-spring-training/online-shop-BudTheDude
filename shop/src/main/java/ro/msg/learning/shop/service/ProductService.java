package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoryService productCategoryService;

    private final SupplierService supplierService;

    public void save(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productDTO,Product.class);
        int categoryID =productDTO.getCategoryID();
        int supplierID =productDTO.getSupplierID();

        ProductCategory productCategory = productCategoryService.getByID(categoryID);
        Supplier supplier = supplierService.getByID(supplierID);

        product.setCategory(productCategory);
        product.setSupplier(supplier);

        productRepository.save(product);
    }



    public void deleteByID(int id){
        productRepository.deleteById(id);
    }

    public ProductDTO readByID(int id){
        Product product = productRepository.findById(id).get();

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> readAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        ModelMapper modelMapper = new ModelMapper();
        products.forEach((n) -> productDTOS.add(modelMapper.map(n,ProductDTO.class)));

        return productDTOS;
    }

    public void update(int id, ProductDTO productDTO){
        Product product = productRepository.findById(id).get();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setImageUrl(productDTO.getImageUrl());

        int categoryID =productDTO.getCategoryID();
        int supplierID =productDTO.getSupplierID();

        ProductCategory productCategory = productCategoryService.getByID(categoryID);
        Supplier supplier = supplierService.getByID(supplierID);

        product.setCategory(productCategory);
        product.setSupplier(supplier);

        productRepository.save(product);
    }

}
