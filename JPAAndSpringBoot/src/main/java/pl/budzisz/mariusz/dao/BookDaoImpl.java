package pl.budzisz.mariusz.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import pl.budzisz.mariusz.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@PersistenceUnit
    private EntityManagerFactory  emf;

    public BookDaoImpl() {
    }

    public void save(Book book) {
    	EntityManager emg = emf.createEntityManager();
        EntityTransaction tx = emg.getTransaction();
        tx.begin();
        emg.persist(book);
        tx.commit();
        emg.close();
    }

    public Book get(Long id) {
    	EntityManager emg = emf.createEntityManager();
        Book book = emg.find(Book.class, id);
        return book;
    }

    public void cleanUp() {
    	EntityManager emg = emf.createEntityManager();
        emg.close();
    }
}
