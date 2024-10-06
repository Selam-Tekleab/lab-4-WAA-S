package cs545;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Book  extends Product{
    private String title;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
