public class Main {

    public static void main(String[] args) {
        System.out.println(reverseWords(" the  sky   is   blue  "));
    }

    public static String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        String newString = "";
        for(int i = 0; i < strings.length; i++) {
            if(i != 0) {
                newString += " ";
            }
            newString += reverse(strings[i].toCharArray(), 0, strings[i].length()-1);
        }
        char[] chars = newString.toCharArray();
        return reverse(chars, 0, chars.length - 1);
    }

    public static String reverse(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        return new String(chars);
    }
}
