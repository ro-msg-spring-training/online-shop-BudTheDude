package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String timeStamp;
    private int customerID;
    private String country;
    private String city;
    private String county;
    private String streetAddress;
    private List<SimplifiedProductDTO> products;

}
