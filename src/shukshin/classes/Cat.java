package shukshin.classes;

import shukshin.annotations.Invoke;
import shukshin.annotations.Two;

@Two(first = "Орешек", second = 1)
public class Cat {
    private final String name;
    public Cat(String name) {
        this.name = name;
    }
    @Invoke
    public void meow() {
        System.out.println(name + ": мяу!");
    }
    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
