import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

    List<Integer> list;
    Stack<Integer> stack;
    int len;
    int min;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());  //
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());  //
    }

    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
        len = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x < min) {
            min = x;
        }
        stack.push(x);
        list.add(min);
        len++;
    }

    public void pop() {
        stack.pop();
        list.remove(len - 1);
        len--;
        if (len >= 1) {
            min = list.get(len - 1);
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.lastElement();
    }

    public int getMin() {
        return min;
    }
}
