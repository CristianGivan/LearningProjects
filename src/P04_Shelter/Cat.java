package P04_Shelter;

public class Cat extends Animal{

    public static final String TYPE_OF_ANIMAL="Cat";

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Pisica "+getName()+" face miau");
    }
}
