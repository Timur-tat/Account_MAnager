package com.example.data;
import com.example.data.homework1818.FilmID;
import com.example.data.homework1818.Film;
import com.example.data.Servise.FilmService;


import com.example.data.Entity.Product;
import com.example.data.Entity.SingleTable.Car1;
import com.example.data.Entity.SingleTable.Car2;
import com.example.data.Entity.Status;
import com.example.data.Entity.myUser;
import com.example.data.Reps.*;
import com.example.data.Servise.BookServise;
import com.example.data.Servise.CarServise;
import com.example.data.Servise.FilmService;
import com.example.data.Servise.MyUserSevise;
import com.example.data.homework1818.FilmID;
import com.example.data.keys.Book;
import com.example.data.keys.BookId;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class DataApplication implements CommandLineRunner {
    @Autowired
    MyUserSevise myUserSevise;
    @Autowired
    CarServise carServise;
    @Autowired
    Car1Rep car1Rep;
    @Autowired
    Car2Rep car2Rep;
    @Autowired
    myUserRep myUserRep;
    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }
@Autowired
    ProductRep productRep;
    @Autowired
    BookServise bookServise;
    @Autowired
    FilmService filmService;
    @Autowired
    FilmRep filmRep;
    @Autowired
    BaseEntityRep baseEntityRep;
    @Override



    public void run(String... args) throws Exception {
        //сделать репозитории для кадж класса, сохр все классы и посмотреть резуль, прочитать хабр
        myUser myUser = new myUser("USER1","USER1");
//       myUserRep.save(myUser);
        Product product = new Product("Компьютер",100.999);
//     productRep.save(product);
        System.out.println(myUserRep.findAll());
        System.out.println(myUserSevise.findBy("username","USER1"));
        System.out.println(myUserSevise.findBy("password","USER1"));
        Car1 car1 = new Car1("Bmw",100);
        //car1Rep.save(car1);
        Status status1 = Status.OPEN;
        Status status2 = Status.APPROVED;
        Status status3 = Status.REVIEW;
        Status status4 = Status.REJECTED;
        Car2 car2 = new Car2("Mersedes2",status1,status2,120);
        BookId bookId = new BookId("Война_и_мир2", "Russian1");
        Book book = new Book(bookId,"Война_и_мир2");
        FilmID filmId = new FilmID("боевик", 2010);
        Film film= new Film(filmId, "Миссия_невыполнима","Американский");
        // filmService.createFilm("хорор4", 2018);




//        bookServise.createBook(book);
//        bookServise.createBook("Невойна_и_мир", "English", "Некрасов");
       // car2Rep.save(car2);


        System.out.println(carServise.findBy1("speed",100));
        System.out.println(carServise.findBy2("speed",100, "name", "Mersedes" ));
        System.out.println("//////////////////////////////");
        System.out.println(car1Rep.findAll(specification1("name", "Bmw")));
        System.out.println("/////////////////////");
        System.out.println(car2Rep.findAll(specification2("name", "Mersedes2")));
        Status status5 = Status.OPEN;
        System.out.println(car2Rep.findByStatus1(status5));
       // car2Rep.addCar(99,"lada", 99);
        //carServise.addCar(9119, "Lada1",1213);
        //car2Rep.addCar1(2313,"Geep1", 3100);
        System.out.println(car2Rep.getCarNames());
        System.out.println(carServise.getCarsCount());
        Integer inputValue = 5;
        Integer inoutValue = 10; // Значение для INOUT Integer
        Integer outputValue = null; // Значение для OUT (будет заполнено процедурой)
        car2Rep.calculateValues(inputValue, inoutValue, outputValue);
        System.out.println("Input Value: " + inputValue);
        System.out.println("INOUT Value (modified): " + inoutValue);
        System.out.println("OUT Value: " + outputValue);
        System.out.println(carServise.getCarsWithSpeedGreaterThan100());
        System.out.println(bookServise.findBookById("Война_и_мир", "Russian"));
        System.out.println(bookServise.findBooksByTitleLike("Невойна"));
        System.out.println(bookServise.findBookByBookId(bookId));
        System.out.println(baseEntityRep.findBookByBookId(bookId));
        System.out.println(filmService.findFilmsByGenreLike("хорор"));
        //for ( int i =0; i< 10; i++){
       // System.out.println(bookServise.findBooksByAuthor("Некрасов"));
        //}
        for (int i =0; i< 10; i++) {
            System.out.println(bookServise.findAllBooks());
            if (i==8){
               // bookServise.updateBookCache(new Book(new BookId("Невойна_и_мир","English"),"Некрасов3"));
                bookServise.saveOrUpdateBook(new Book(new BookId("Невойна_и_мир","English"),"Некрасов7"));
            }
            if (i == 5) {
                bookServise.clearCache();
            }
        }

            System.out.println(bookServise.findAllBooks());





// создать класс составной первич ключ с embedeble класс





    }
    public static Specification<Car1> specification1(String fild, String value) {
        return (car1, criteriaQuery, criteriaBuilder)-> criteriaBuilder.equal(car1.get(fild),value);

    }
    public static Specification<Car2> specification2(String fild, String value) {
        return (car2, criteriaQuery, criteriaBuilder)-> criteriaBuilder.equal(car2.get(fild),value);

    }

}
