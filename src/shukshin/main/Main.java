package shukshin.main;

import shukshin.classes.*;
import shukshin.reflection.*;
import java.util.*;
/**
 * Главный класс приложения для демонстрации работы.
 * <p>Предоставляет меню для выбора различных задач по работе с аннотациями.</p>
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1 Задача: Аннотация @Invoke");
            System.out.println("2 Задача: Аннотация @Default");
            System.out.println("3 Задача: Аннотация @ToString");
            System.out.println("4 Задача: Аннотация @Validate");
            System.out.println("5 Задача: Аннотация @Two");
            System.out.println("6 Задача: Аннотация @Cache");
            System.out.println("7 Задача 2.1: Тест @ToString");
            System.out.println("8 Задача 2.4: Тест @Validate");
            System.out.println("0 Выход");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Введите имя кота: ");
                    String Name = scanner.nextLine();
                    try {
                        Cat cat = new Cat(Name);
                        System.out.println("\nТестирование @Invoke:");
                        InvokeReflection.showInvoke(cat);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                case 2:
                    try {
                        System.out.println("\nТестирование @Default:");
                        Book book=new Book();
                        DefaultReflection.showDefault(book);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("\nТестирование @ToString:");
                        User user=new User();
                        ToStringReflection.generateToString(user);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        User user1=new User();
                        ValidateReflection.showValidate(user1);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Введите имя кота: ");
                    String Name1 = scanner.nextLine();
                    try {
                        System.out.println("\nТестирование @Two:");
                        Cat cat1=new Cat(Name1);
                        TwoReflection.showTwo(Name1);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("\nТестирование @Cache:");
                        User user2=new User();
                        CacheReflection.showCache(user2);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        }while(choice!=0);
    }
}