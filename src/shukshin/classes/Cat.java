package shukshin.classes;

import shukshin.annotations.Invoke;
import shukshin.annotations.Two;

/**
 * Класс, представляющий кота.
 * Демонстрирует использование аннотаций @Two и @Invoke
 */

@Two(first = "Орешек", second = 1)
public class Cat {
    /** Имя кота */
    private final String name;

    public Cat() {
        this.name = "Стандартный кот";
    }

    /**
     * Создает кота с указанным именем.
     *
     * @param name имя кота
     */
    public Cat(String name) {
        this.name = name;
    }

    /**
     * Метод, вызываемый автоматически при обработке аннотации @Invoke
     * Выводит в консоль мяуканье кота.
     */
    @Invoke
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    /**
     * Возвращает строковое представление кота
     *
     * @return строковое представление в формате "Кот: [имя]"
     */
    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
