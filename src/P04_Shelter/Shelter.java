package P04_Shelter;

public class Shelter {
    private final int MAX_ANIMAL_NR;
    private int nrOfAnimals;
    private Animal[] animals;

    public Shelter(int MAX_ANIMAL_NR) {
        this.MAX_ANIMAL_NR = MAX_ANIMAL_NR - 1;
        nrOfAnimals = 0;
        animals = new Animal[MAX_ANIMAL_NR];
    }

    public boolean addAnimal(Animal animal) {

        if (nrOfAnimals <= MAX_ANIMAL_NR) {
            this.animals[nrOfAnimals] = animal;
            nrOfAnimals++;
            return true;
        }
        return false;
    }

    public void displayAnimals() {
        for (int i = 0; i < nrOfAnimals; i++) {
            System.out.println("Animalul se numeste " + animals[i].getName() +
                    "and it is " + animals[i].getAge() + " old");
        }
    }

    public void makeNoise() {
        for (int i = 0; i < nrOfAnimals; i++) {
            animals[i].makeSound();
        }
    }


    public int getMAX_ANIMAL_NR() {
        return MAX_ANIMAL_NR;
    }

    public int getNrOfAnimals() {
        return nrOfAnimals;
    }

    public Animal[] getAnimals() {
        return animals;
    }


}
