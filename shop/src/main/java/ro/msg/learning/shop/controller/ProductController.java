package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.service.ProductCategoryService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public String postProduct(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
        return "Saved";
    }

    @GetMapping("/{id}")
    public ProductDTO getProductByID(@PathVariable int id){
        return productService.readByID(id);
    }


    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody ProductDTO productDTO){
        productService.update(id,productDTO);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteByID(id);
        return "Deleted";
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.readAll();
    }

}
