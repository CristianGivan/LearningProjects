package P04_Shelter;

public class Dog extends Animal {

    public static final String TYPE_OF_ANIMAL="Dog";

    public Dog(String name) {
        super(name);

    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Cainele " + getName() + " latra");
    }
}
