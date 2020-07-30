package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.entity.Supplier;
import ro.msg.learning.shop.service.ProductCategoryService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductCategoryService productCategoryService;

    private final SupplierService supplierService;

    @PostMapping
    public String postProduct(@RequestBody ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productDTO, Product.class);
        int categoryID = productDTO.getCategoryID();
        int supplierID = productDTO.getSupplierID();

        ProductCategory productCategory = productCategoryService.getByID(categoryID);
        Supplier supplier = supplierService.getByID(supplierID);

        product.setCategory(productCategory);
        product.setSupplier(supplier);

        productService.save(product);
        return "Saved";
    }

    @GetMapping("/{id}")
    public ProductDTO getProductByID(@PathVariable int id) {
        return productService.readByID(id);
    }


    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        productService.update(id, productDTO);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteByID(id);
        return "Deleted";
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.readAll();
    }

}
