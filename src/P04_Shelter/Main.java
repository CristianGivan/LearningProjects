package P04_Shelter;

public class Main {
    public static void main(String[] args) {
        Animal animal1=new Cat("Tom", 2);
        Animal animal2=new Cat("Toms", 5);
        Animal animal3=new Dog("Azor", 2);
        Animal animal4=new Dog("Grivei", 7);
        //Animal animal1=new Cat("Tom", 2);

        Shelter shelter5=new Shelter(5);
        shelter5.addAnimal(animal1);
        shelter5.addAnimal(animal2);
        shelter5.addAnimal(animal3);
        shelter5.addAnimal(animal4);
        //shelter5.addAnimal(animal1);

        shelter5.makeNoise();

     //debug
    /*
        Animal[] animals = shelter5.getAnimals();
        int indexOfAnimal =3;
        //System.out.println(animals[indexOfAnimal].getName());
        shelter5.displayAnimals();
        //System.out.println(animals[indexOfAnimal].getName());
    */
    }

}
