import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 9, 9, 9};
        printArray(plusOne1(nums));
    }

    // BigInteger
    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return null;
        }
        BigInteger bi = new BigInteger("0");
        int len = digits.length;
        for(int i = 0; i < len; i++) {
            bi = bi.add(new BigInteger(Integer.toString((int)(digits[i] * Math.pow(10, len - 1 - i)))));
        }
        bi = bi.add(new BigInteger("1"));
        char[] chars = bi.toString().toCharArray();
        int newLen = chars.length;
        int[] newNum = new int[newLen];
        int count = 0;
        for(char c : chars) {
            newNum[count++] = c - '0';
        }
        return newNum;
    }

    public static int[] plusOne1(int[] digits) {
        if(digits == null || digits.length == 0) {
            return null;
        }
        int len = digits.length;
        int add = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(i == len - 1) {
                if(digits[i] == 9) {
                    digits[i] = 0;
                    add = 1;
                } else {
                    digits[i] += 1;
                    add = 0;
                }
            } else {
                if(add == 1) {
                    if(digits[i] == 9) {
                        digits[i] = 0;
                        add = 1;
                    } else {
                        digits[i] += 1;
                        add = 0;
                    }
                }
            }
        }
        if(add == 1) {
            int[] newArray = new int[len + 1];
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, len);
            return newArray;
        } else {
            return digits;
        }
    }

    public static void printArray(int[] digits) {
        for(int i : digits) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
