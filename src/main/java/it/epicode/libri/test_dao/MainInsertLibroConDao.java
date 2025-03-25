package it.epicode.libri.test_dao;

import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainInsertLibroConDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        // creiamo un entity manager
        EntityManager em = emf.createEntityManager();

        // usiamo entity maneger per inserire un libro nel db
        Libro l = new Libro("La casa nella prateria", "Bo", 1934);
        Libro l1 = new Libro("La collino dei misteri", "Giovannino", 1994);
        Libro l2 = new Libro("La casa delle meraviglie", "ugo", 1954);

        // mi istanzio una classe dao
        LibroDAO dao = new LibroDAO(em);
        // uso l'insert tramite arraylist overload del metodo insert di un libro singolo
        dao.insert(List.of(l, l1, l2));

        // chiudiamo l'entity manager
        em.close();
        // chiudiamo l'entity manager factory
        emf.close();



    }
}
