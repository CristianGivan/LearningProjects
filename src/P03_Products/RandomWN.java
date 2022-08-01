package P03_Products;

import java.util.Locale;

public class RandomWN {

    //Options for word: camel case, contain numbers, contain symbols
    public String word;
    public String words;
    public String[] wordArray;
    public String[] wordsArray;
    public int number;
    public int[] numberArray;


    public RandomWN() {
    }


    public String generateRandomWord(int numberOfChar, String charactesToChose) {


        StringBuilder word = new StringBuilder(numberOfChar);

        if (charactesToChose != null) {

            for (int i = 0; i <= numberOfChar; i++) {
                int characterNumber = (int) (charactesToChose.length() * Math.random());
                word.append(charactesToChose.charAt(characterNumber));

            }
        } else {
            return  "Unknown";
        }
        return word.toString();
    }

    public String charactersToChose(int option) {

        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        final String lower = upper.toLowerCase(Locale.ROOT);

        final String digits = "0123456789";

        final String alphanum = upper + lower + digits;

        String stringOption;

        switch (option) {
            case 1:
                stringOption = upper;
                break;
            case 2:
                stringOption = lower;
                break;
            case 3:
                stringOption = digits;
                break;
            case 4:
                stringOption = alphanum;
                break;
            default:
                stringOption = null;
                break;

        }
        return stringOption;
    }

}
