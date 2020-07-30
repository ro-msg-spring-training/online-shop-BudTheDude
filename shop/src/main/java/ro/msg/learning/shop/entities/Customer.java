package ro.msg.learning.shop.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email_Address")
    private String emailAddress;


    @OneToMany(mappedBy = "customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;
}
