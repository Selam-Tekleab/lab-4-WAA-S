package cs545;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Payment {
    private String paydate;
    private double amount;


    @Override
    public String toString() {
        return "Payment{" +
                "paydate='" + paydate + '\'' +
                ", amount=" + amount +
                '}';
    }
}
