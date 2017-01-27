import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String s = "[[";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<Character ,Integer>();
        map.put('(', 0);
        map.put(')', 0);
        map.put('[', 1);
        map.put(']', 1);
        map.put('{', 2);
        map.put('}', 2);
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if(map.get(top).equals(map.get(c)) && top != c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
