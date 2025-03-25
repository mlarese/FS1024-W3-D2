package it.epicode.libri.test_dao;

import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainUpdateLibroConDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDao = new LibroDAO(em);
        Libro l = libroDao.find(3L);

        l.setAnnoPubblicazione(2010);
        libroDao.update(l);

        em.close();
        emf.close();


    }

}
