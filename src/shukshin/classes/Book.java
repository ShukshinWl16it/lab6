package shukshin.classes;
import shukshin.annotations.Default;
import shukshin.annotations.ToString;
/**
 * Класс, представляющий книгу в библиотечной системе.
 * Аннотирован с помощью @Default и @ToString для демонстрации
 * работы с пользовательскими аннотациями.
 */
@Default(String.class)
@ToString
public class Book {
    /** Название книги */
    private String title;

    /** Автор книги */
    private String author;

    /** Цена книги, включает в строковое представление */
    @ToString(ToString.Mode.YES)
    private double price;

    /** Количество экземпляров на складе, исключается из строкового представления */
    @ToString(ToString.Mode.NO)
    private int stock;

    /**
     * Создает книгу с значениями по умолчанию.
     * Используется, когда нет конкретных данных о книге.
     */
    public Book() {
        this("Неизвестная книга", "Неизвестный автор", 0.0, 0);
    }

    /**
     * Создает книгу с указанными параметрами.
     *
     * @param title  название книги
     * @param author автор книги
     * @param price  цена книги
     * @param stock  количество экземпляров на складе
     */
    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Возвращает строковое представление книги.
     * Включает только те поля, которые помечены аннотацией @ToString с режимом YES
     * или не имеют аннотации. Поле stock исключено из вывода.
     *
     * @return строковое представление книги в формате Book[title=' ', author=' ', price=]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book[");

        // поля без аннотации или с @ToString(Mode.YES) включаем
        sb.append("title='").append(title).append(", ");
        sb.append("author='").append(author).append(", ");
        sb.append("price=").append(price);

        // поле stock с @ToString(Mode.NO) не включаем

        sb.append("]");
        return sb.toString();
    }
}
