package ArraysAndStrings;

public class DetermineIfStringHasOnlyUniqueChars {
    public static void main(String[] args) {
        String input = "something";
        String input2 = "icecream";
        System.out.println(isUnique(input));
        System.out.println(isUnique(input2));

    }

    public static boolean isUnique(String input){
        char[] inputArray = input.toCharArray();
        boolean[] asciiChars = new boolean[256];
        for (int i = 0; i < inputArray.length; i++) {
            int character = inputArray[i];
            //System.out.println(character);
            if(asciiChars[character]){
                return false;
            }
            asciiChars[character] = true;
        }

        return true;
    }
}
