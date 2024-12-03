package com.example.webApp;

import com.example.webApp.model.Gender;
import com.example.webApp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class WebAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // Beginne eine Transaktion
            em.getTransaction().begin();

            // Erstelle eine neue Entity
            User entity = User.builder()
                    .firstName("Kimbo")
                    .lastName("Slice")
                    .age(25)
                    .gender(Gender.MALE)
                    .status(false)
                    .dateOfBirth(LocalDate.now())
                    .build();

            // Speichere die Entity
            em.persist(entity);

            // Commit der Transaktion
            em.getTransaction().commit();

            System.out.println("Entity wurde gespeichert mit ID: " + entity.getId());
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
