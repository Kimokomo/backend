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
        this.emf = Persistence.createEntityManagerFactory("myJpaUnit");
    }

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public void startTransaction() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        EntityManager em = getEntityManager();
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    public void save(User user) {
        startTransaction();
        try {
            em.persist(user);
            commitTransaction();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
        return query.getResultList();
    }

    public Optional<User> findById(Long id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    public void close() {
        emf.close();
    }
}
