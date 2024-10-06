package cs545;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class DVD extends Product {

    private String genere;

    @Override
    public String toString() {
        return "DVD{" +
                "genere='" + genere + '\'' +
                '}';
    }
}
