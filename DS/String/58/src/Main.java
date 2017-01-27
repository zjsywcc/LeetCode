public class Main {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
    }

    public static int lengthOfLastWord(String s) {
        String[] rst = s.split(" ");
        if(rst.length == 0) {
            return 0;
        }
        String str = rst[rst.length - 1];
        return str.length();
    }
}
