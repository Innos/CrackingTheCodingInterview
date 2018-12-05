package ArraysAndStrings;

import java.util.HashMap;

public class CheckIfStringIsPermutation {
    public static void main(String[] args) {
        String a = "dogge";
        String b = "Godge";
        System.out.println(isPermutation(a, b));
    }

    public static boolean isPermutation(String a, String b){
        HashMap<Character,Integer> foundLetters = new HashMap<>();
        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            char currentCharacter = a.charAt(i);
            if(!foundLetters.containsKey(currentCharacter)){
                foundLetters.put(currentCharacter,0);
            }

            foundLetters.put(a.charAt(i),foundLetters.get(currentCharacter) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            char currentCharacter = b.charAt(i);
            if(!foundLetters.containsKey(currentCharacter)){
                return false;
            }
            else if(foundLetters.get(currentCharacter) == 1){
                foundLetters.remove(currentCharacter);
            }
            else{
                foundLetters.put(b.charAt(i), foundLetters.get(currentCharacter) - 1);
            }
        }

        if(foundLetters.keySet().size() > 0){
            return false;
        }

        return true;
    }
}
