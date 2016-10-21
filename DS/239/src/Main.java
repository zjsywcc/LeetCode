import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
//        int[] nums = new int[]{1,3,1,2,0,5};
        printList(maxSlidingWindow(nums, 3));
    }

    public static class Tuple {
        int index;
        int num;

        public Tuple(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int len = nums.length;
        ArrayDeque<Tuple> deque = new ArrayDeque<Tuple>();
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] > deque.peekFirst().num) {
                deque.removeFirst();
            }
            deque.offerFirst(new Tuple(nums[i], i));
        }
        int[] result = new int[len - k + 1];
        int index = 0;
        result[index++] = deque.peekLast().num;
        for(int i = 1, j = k; j < len; i++, j++) {
            if(deque.peekLast().index < i) {
                deque.removeLast();
            }
            while(!deque.isEmpty() && nums[j] > deque.peekFirst().num) {
                deque.removeFirst();
            }
            deque.offerFirst(new Tuple(nums[j], j));
            result[index++] = deque.peekLast().num;
        }
        return result;
    }

    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(String.format("%s ", i));
        }
        System.out.println();
    }
}
