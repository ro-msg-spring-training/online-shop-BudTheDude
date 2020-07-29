package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

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
    private List<Product> products;
}
