package P03_Products;

import java.util.Scanner;

public class TestRandom {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int option;
        int numbreOfChar;

        RandomWN random = new RandomWN();

        do {

            System.out.println("Insert the number of characters: ");
            numbreOfChar = console.nextInt();
            System.out.println("Insert the type of characters: ");
            option = console.nextInt();
            //random.word = "test";
            String CharactersToChose = random.charactersToChose(option);
            String randomWord = random.generateRandomWord(numbreOfChar, CharactersToChose);

            System.out.println(random.word);
            System.out.println(randomWord);


        } while (option != 0);
        System.out.println(option + " characters is exiting the program!");
    }
}
