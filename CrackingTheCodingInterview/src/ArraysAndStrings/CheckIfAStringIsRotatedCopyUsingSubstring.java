package ArraysAndStrings;


public class CheckIfAStringIsRotatedCopyUsingSubstring {
    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "erbottlewat";
        System.out.println(isRotation(a,b));
    }

    public static boolean isRotation(String a, String b){
        if(a == null ||
            b == null ||
            a.isEmpty() ||
            b.isEmpty() ||
            a.length() != b.length()){
            return false;
        }

        //if b is a rotation of a then b must be a substring of a + a
        String joinedOriginalString = a + a;
        return isSubstring(b, joinedOriginalString);
    }

    public static boolean isSubstring(String substring, String text){
        return text.contains(substring);
    }
}
