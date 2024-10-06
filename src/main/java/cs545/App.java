package cs545;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs545");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer= new Customer("Maggie","Shegaw");
        em.persist(customer);

        Order order = new Order(new Date(),customer);
        em.persist(order);
        Order order2 = new Order(new Date(),customer);
        em.persist(order2);

        Product product1 = new Product("prod-1","bla bla bla");
        Product product2= new Product("prod-2","bla bla bla");
        em.persist( product2);
        em.persist( product1);

        OrderLine orderLine = new OrderLine(25,product1);
        em.persist(orderLine);
        OrderLine orderLine2= new OrderLine(34,product2);
        em.persist(orderLine2);
        OrderLine orderLine3= new OrderLine(45,product2);
        em.persist(orderLine3);

        TypedQuery<Customer> custQuery= em.createQuery("from Customer", Customer.class);
        List<Customer> customers = custQuery.getResultList();
        Customer maggie= customers.get(0);
        System.out.println("Customer " + maggie);

        TypedQuery<Order> orderQuery= em.createQuery("from Order where customer.id=:c_id", Order.class);
        orderQuery.setParameter("c_id",maggie.getId());
        List<Order> ordersR = orderQuery.getResultList();
        System.out.println("an order for maggie " + ordersR);

        TypedQuery<OrderLine> OrderLinesR= em.createQuery("from OrderLine ", OrderLine.class);
        List<OrderLine> OrderLineR = OrderLinesR.getResultList();
        System.out.println("order line " + OrderLineR);

        TypedQuery<Product> proQ= em.createQuery("from Product ", Product.class);
        List<Product> productsR = proQ.getResultList();
        System.out.println("products  " + productsR);



        em.getTransaction().commit();
        em.close();

    }


}

class AppInheritance{
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs545");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CD p1 = new CD();
        em.persist(p1);
        p1.setArtist("Selame");
        p1.setName("cd_1");

        DVD p2 = new DVD();
        em.persist(p2);

        p2.setGenere("BioGraphy");
        p2.setName("dvd_1");


        Book p3 = new Book();
        em.persist(p3);

        p3.setTitle("Something");
        p3.setName("book_1");
        TypedQuery<Product> proQ= em.createQuery("from Product ", Product.class);
        List<Product> productsR = proQ.getResultList();
        System.out.println("products  " + productsR);

        em.getTransaction().commit();
        em.close();

    }

}
