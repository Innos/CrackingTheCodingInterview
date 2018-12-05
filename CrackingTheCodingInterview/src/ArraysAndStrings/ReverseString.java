package ArraysAndStrings;


public class ReverseString {
    public static void main(String[] args) {
        String input = "pesho";
        char[] inputArr = input.toCharArray();

        for (int i = 0, j = inputArr.length - 1; i < j; i++, j--){
            char temp = inputArr[i];
            inputArr[i] = inputArr[j];
            inputArr[j] = temp;
        }

        String recombinedInput = new String(inputArr);
        System.out.println(recombinedInput);
    }
}
