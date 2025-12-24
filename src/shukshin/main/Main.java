package shukshin.main;

import shukshin.classes.*;
import shukshin.reflection.*;
import java.util.*;
/**
 * Главный класс приложения для демонстрации работы с пользовательскими аннотациями.
 * Предоставляет интерактивное консольное меню для выбора различных задач
 * по работе с аннотациями через Reflection API.
 */
public class Main {
    /**
     * Точка входа в приложение.
     * Запускает интерактивное меню для демонстрации работы с аннотациями.
     * Пользователь может выбирать различные опции для тестирования функциональности.
     */
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
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Введите имя кота: ");
                    String Name = scanner.nextLine();
                    try {
                        Cat cat = new Cat(Name);
                        System.out.println("Создан кот: " + cat);
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
                        System.out.println("Создана книга: " + book);
                        DefaultReflection.showDefault(book);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("\nТестирование @ToString:");
                        User user=new User();
                        System.out.println("Создан пользователь:");
                        String result =ToStringReflection.generateToString(user);
                        System.out.println(result);
                        System.out.println("В строке нет пароля, значит все работает");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        User user1=new User();
                        System.out.println("Создан пользователь для валидации");
                        ValidateReflection.showValidate(user1);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("\nТестирование @Two:");
                        Cat cat1=new Cat();
                        System.out.println("Создан кот: " + cat1);
                        TwoReflection.showTwo(cat1);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("\nТестирование @Cache:");
                        User user2=new User();
                        System.out.println("Создан пользователь с аннотацией @Cache");
                        CacheReflection.showCache(user2);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Запустите тест testToString в пакете test");
                    break;
                case 8:
                    System.out.println("Запустите тест testValidate в пакете test");
                    break;
            }
        }while(choice!=0);
    }
}