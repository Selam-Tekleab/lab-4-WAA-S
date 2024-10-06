package cs545;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainApplication {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs545");

        EntityManager em = emf.createEntityManager();


        Doctor doctor = new Doctor("John", "Doe");
        doctor.setDoctorType("General Physician");

        Patient patient = new Patient();
        patient.setName("Alice");
        patient.setStreet("123 Main St");
        patient.setCity("City");
        patient.setZip("12345");

        Payment payment = new Payment();
        payment.setPaydate("2023-06-06");
        payment.setAmount(100.0);

        Appointment appointment = new Appointment();
        appointment.setAppdate("2023-06-07");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setPayment(payment);


        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(doctor);
        em.persist(patient);
        em.persist(appointment);


        tx.commit();


        Doctor retrievedDoctor = em.find(Doctor.class, doctor.getId());
        System.out.println("Retrieved Doctor: " + retrievedDoctor);

        Patient retrievedPatient = em.find(Patient.class, patient.getId());
        System.out.println("Retrieved Patient: " + retrievedPatient);

        Appointment retrievedAppointment = em.find(Appointment.class, appointment.getId());
        System.out.println("Retrieved Appointment: " + retrievedAppointment);


        em.close();
        emf.close();
    }
}

