package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int id;
    private String name;
    private String description;
    private long price;
    private double weight;
    private String imageUrl;

    private int supplierID;
    private String supplierName;

    private int categoryID;
    private String categoryName;
    private String categoryDescription;

}
