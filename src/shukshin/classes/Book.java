package shukshin.classes;
import shukshin.annotations.Default;
import shukshin.annotations.ToString;

@Default(String.class)
@ToString
public class Book {

    private String title;
    private String author;

    @ToString(ToString.Mode.YES)
    private double price;

    @ToString(ToString.Mode.NO)
    private int stock;
    public Book() {
        this("Неизвестная книга", "Неизвестный автор", 0.0, 0);
    }
    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }
}
