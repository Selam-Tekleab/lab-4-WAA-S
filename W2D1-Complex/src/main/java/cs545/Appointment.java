package cs545;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;
    @OneToOne
    private Patient patient;
    @Embedded
    private Payment payment;



    @OneToOne
    private Doctor doctor;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appdate='" + appdate + '\'' +
                ", patient=" + patient +
                ", payment=" + payment +
                ", doctor=" + doctor +
                '}';
    }
}
