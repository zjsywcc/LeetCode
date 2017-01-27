package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String start = "1";
        int index = 1;
        while(index < n) {
            start = generateNext(start);
            index++;
        }
        return start;
    }

    public static String generateNext(String num) {
        int len = num.length();
        char c = num.charAt(0);
        int index = 1;
        int count = 1;
        String rst = "";
        while(index < len) {
            if(num.charAt(index) == c) {
                count++;
            } else {
                rst += "" + count + c;
                c = num.charAt(index);
                count = 1;
            }
            index++;
        }
        rst += "" + count + c;
        return rst;
    }
}
