package pl.budzisz.mariusz.dao;

import pl.budzisz.mariusz.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(Long id);
    public void cleanUp();
}
