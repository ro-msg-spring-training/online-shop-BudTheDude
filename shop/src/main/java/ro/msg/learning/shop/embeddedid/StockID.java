package ro.msg.learning.shop.embeddedid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockID implements Serializable {

    @Column
    private int productID;

    @Column
    private int locationID;


}
