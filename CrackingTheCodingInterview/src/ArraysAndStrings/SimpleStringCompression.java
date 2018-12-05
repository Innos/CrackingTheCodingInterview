package ArraysAndStrings;


public class SimpleStringCompression {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abcdef"));

    }

    public static String compressString(String input){
        if(input == null || input.isEmpty()){
            return input;
        }

        StringBuilder sb = new StringBuilder();
        int repeats = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                repeats++;
            } else {
                sb.append(input.charAt(i - 1)).append(repeats);
                repeats = 1;
            }
        }

        sb.append(input.charAt(input.length() - 1)).append(repeats);
        String newString = sb.toString();

        return newString.length() >= input.length() ? input : newString;
    }
}
