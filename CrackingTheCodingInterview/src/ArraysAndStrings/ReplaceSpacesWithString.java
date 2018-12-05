package ArraysAndStrings;

public class ReplaceSpacesWithString {
    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        char[] inputArr = input.toCharArray();

        int lastLetterIndex = 0;
        for (int i = inputArr.length - 1; i >= 0; i--) {
            if(inputArr[i] != ' '){
                lastLetterIndex = i;
                break;
            }
        }

        System.out.println(lastLetterIndex);
        int backIndex = inputArr.length - 1;
        for (int i = lastLetterIndex; i >= 0; i--) {
            if(inputArr[i] == ' '){
                inputArr[backIndex--] = '0';
                inputArr[backIndex--] = '2';
                inputArr[backIndex--] = '%';
            }
            else{
                inputArr[backIndex--] = inputArr[i];
            }
        }

        String recombinedString = new String(inputArr);
        System.out.println("\"" + recombinedString + "\"");
    }
}
