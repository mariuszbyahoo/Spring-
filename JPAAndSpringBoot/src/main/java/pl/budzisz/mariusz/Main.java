package pl.budzisz.mariusz;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.budzisz.mariusz.dao.BookDao;
import pl.budzisz.mariusz.model.Book;

@SpringBootApplication
public class Main {
	public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(Main.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        //zapisujemy
        Book book = new Book("3332222555", "Wreszcie się udało to zapisać?", "Javastart");
        bookDao.save(book);
        //odczytujemy
        Book bookGet = bookDao.get(1L);
        System.out.println("\n\n\n" + bookGet + "\n\n\n");
        
        Thread.sleep(2000);
        ctx.close();
    }
}
