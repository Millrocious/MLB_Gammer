package core;

public class CodeController {
    public static long invertNumber(long code) {
        return ~code;
    }

    private static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }

    public static long lcm(long a,long b){
        return a / gcd(a,b) * b;
    }

    public static int getBitLengthOfInteger(int N) {
        return (int) (1 + Math.floor(Math.log(N) / Math.log(2)));
    }
}
