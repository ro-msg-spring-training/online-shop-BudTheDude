package ro.msg.learning.shop.embedded_IDs;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StockID implements Serializable {
    int productID;
    int location;
}
