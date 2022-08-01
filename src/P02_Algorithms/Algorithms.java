package Template;

public class Algorithms {
    public static void main(String[] args) {

    }

    public static Object[] deleteInArray(Object[] objects, int toDeleteAt) {

        for (int i = toDeleteAt + 1; i < objects.length; i++) {
            objects[i - 1] = objects[i];
        }
        //numberOfBooks--;
        return objects;
    }

    public static int countNumberOfElementsNotNullInStringArray(Object[] objects){
        int numberOfElementsNotNull = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                numberOfElementsNotNull = i + 1;
            }
        }
        return numberOfElementsNotNull;
    }
}
