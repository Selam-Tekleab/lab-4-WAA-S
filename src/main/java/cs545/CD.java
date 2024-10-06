package cs545;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CD extends Product {
    private String artist;

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
