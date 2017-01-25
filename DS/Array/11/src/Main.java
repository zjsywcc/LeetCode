
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int len = height.length;
        int left = 0, right = len - 1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
