package it.epicode.libri.test_dao;

import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDeleteLibroConDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDao = new LibroDAO(em);

        libroDao.delete(3L);

        em.close();
        emf.close();

    }
}
