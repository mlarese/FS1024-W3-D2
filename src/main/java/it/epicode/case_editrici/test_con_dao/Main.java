package it.epicode.case_editrici.test_con_dao;

import it.epicode.case_editrici.CasaEditrice;
import it.epicode.case_editrici.CasaEditriceDAO;
import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        CasaEditriceDAO casaEditriceDAO = new CasaEditriceDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);

        em.getTransaction().begin();
            // creo una casa editrice
            CasaEditrice ce = new CasaEditrice(null, "Mondadori", "via Roma 1", "Milano");
            Libro l = new Libro("Il signore degli anelli", "Tolkien", 1954);

            casaEditriceDAO.insertNoTx(ce);
            libroDAO.insertNoTx(l);

        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
