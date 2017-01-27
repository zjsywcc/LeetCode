public class Main {

    public static void main(String[] args) {
        System.out.println(addBinary("111", "11111"));
    }

    public static String addBinary(String a, String b) {
        if(a == null || b == null) {
            return "";
        }
        int add = 0;
        int crt1 = a.length() - 1;
        int crt2 = b.length() - 1;
        String rst = "";
        while(crt1 >= 0 && crt2 >= 0) {
            int sum = a.charAt(crt1) - '0' + b.charAt(crt2) - '0' + add;
            if(sum >= 2) {
                add = 1;
                rst = sum % 2 + rst;
            } else {
                add = 0;
                rst = sum + rst;
            }
            crt1--;
            crt2--;
        }
        while(crt1 >= 0) {
            int sum = a.charAt(crt1) - '0' + add;
            if(sum >= 2) {
                add = 1;
                rst = sum % 2 + rst;
            } else {
                add = 0;
                rst = sum + rst;
            }
            crt1--;
        }
        while(crt2 >= 0) {
            int sum = b.charAt(crt2) - '0' + add;
            if(sum >= 2) {
                add = 1;
                rst = sum % 2 + rst;
            } else {
                add = 0;
                rst = sum + rst;
            }
            crt2--;
        }
        if(add == 1) {
            rst = 1 + rst;
        }
        return rst;
    }
}
