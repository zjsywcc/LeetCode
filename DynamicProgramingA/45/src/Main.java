import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(nums));
    }

    public static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    //TODO the implementation is ugly think about the greedy solution
    public static int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        if(len == 1) {
            return 0;
        }
        int local[] = new int[len-1];
        int global[] = new int[len-1];
        local[0] = nums[0];
        global[0] = nums[0];
        int temp = global[0];
        int count = 1;
        if(temp >= len - 1) {
            return count;
        }
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(0, temp));
        for(int i = 1; i < len - 1; i++) {
            if(local[i-1] >= i) {
                local[i] = Math.max(local[i-1], i+nums[i]);
            } else {
                local[i] = local[i-1];
            }
            global[i] = Math.max(global[i-1], local[i]);
            if(global[i] != temp) {
                stack.push(new Pair(i, global[i]));
            }
            temp = global[i];
            if(global[i] >= len - 1) {
                break;
            }
        }
        Pair tempPair = stack.pop();
        int left = tempPair.left;
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            if(left <= pair.right) {
                tempPair = pair;
            } else {
                stack.push(pair);
                count++;
                left = tempPair.left;
            }
        }
        return count+1;
    }
}
