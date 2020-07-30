package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "supplier")
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    @FieldNameConstants.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supplier")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> products;
}
