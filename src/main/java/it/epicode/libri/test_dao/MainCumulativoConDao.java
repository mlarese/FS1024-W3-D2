package it.epicode.libri.test_dao;

import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCumulativoConDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        // creiamo un entity manager
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);

        // il libro non ha l'id ossia id = null
        Libro l = new Libro("Il signore degli anelli", "J.R.R. Tolkien", 1954);

        em.getTransaction().begin();

            // salvando il libro, l'id viene generato e assegnoto all'oggeto l
            libroDAO.insertNoTx(l);

            // cerco il libro con id = 1 lo uso per verificare che il libro sia stato inserito in db, se non ci fosse
            // il libro con id = 1, il metodo find restituisce null

            Libro l2 = libroDAO.find( l.getId() );
            l2.setAutore("J.R.R. Tolkien junior");
            libroDAO.updateNoTx(l2);

            libroDAO.deleteNoTx(l2.getId());

        em.getTransaction().commit();

        // chiudiamo l'entity manager
        em.close();
        // chiudiamo l'entity manager factory

        emf.close();

    }

}
