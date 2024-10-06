package cs545;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Cust_Order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<OrderLine> orderLines=new ArrayList<>();

    public Order() {
    }

    public Order( Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }




    @Override
    public String toString() {
        return "Order{" +
                ", orderId=" + orderId +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
