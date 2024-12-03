package com.example.webApp.repositories;

import com.example.webApp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final EntityManagerFactory emf;
    private EntityManager em;

    public UserRepository() {
        // Create an EntityManagerFactory
        this.emf = Persistence.createEntityManagerFactory("myJpaUnit");
    }

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }

    // Start a transaction
    public void startTransaction() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
    }

    // Commit the transaction
    public void commitTransaction() {
        EntityManager em = getEntityManager();
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    // Save a User entity
    public void save(User user) {
        startTransaction();  // Start the transaction
        try {
            em.persist(user);  // Save the entity
            commitTransaction();  // Commit the transaction
        } catch (Exception e) {
            em.getTransaction().rollback();  // Rollback if any error occurs
            e.printStackTrace();
        } finally {
            em.close();  // Close the EntityManager after the transaction
        }
    }


    // Get all users
    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    // Find by ID
    public Optional<User> findById(Long id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    // Close the EntityManagerFactory
    public void close() {
        emf.close();
    }
}
