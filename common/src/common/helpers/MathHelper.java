package common.helpers;

public class MathHelper {

    public static final double E = 2.71;
    public static final double PI = 3.14;

    public static int square(int val){
        return val * val;
    }

    public static long exponent(int one, int two) {
        long product = one;

        for(int i = 0; i < two - 1; i++) {
            product *= one;
        }
        return product;
    }

    public static boolean greaterThanZero(int n) {
        if(n < 0)
            return true;
        else
            return false;
    }

    public static double circumference(int rad) {
        return 2 * Math.PI * rad;
    }

}
