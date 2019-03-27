package pl.budzisz.mariusz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.budzisz.mariusz.dao.BookDao;
import pl.budzisz.mariusz.model.Book;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(Main.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        //zapisujemy
        Book book = new Book("111222333", "A Spring bez Boota zapisuje bez problemu -.-", "Javastart");
        bookDao.save(book);
        //odczytujemy
        Book bookGet = bookDao.get(1L);
        System.out.println(bookGet);
        ctx.close();
    }
}