package cs545;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    private Product product;
    public OrderLine() {
    }

    public OrderLine(Integer quantity,Product product) {
        this.quantity = quantity;
        this.product=product;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
