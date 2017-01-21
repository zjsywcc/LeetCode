public class Main {

    public static void main(String[] args) {
        System.out.println(myPow(2, 3));
    }


    //recursive
    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                return myPow(1 / x, - (n + 1)) / x;
            }
            return myPow(1 / x, -n);
        } else {
            double part = myPow(x, n / 2);
            return part * part * myPow(x, n % 2);
        }
    }
}
