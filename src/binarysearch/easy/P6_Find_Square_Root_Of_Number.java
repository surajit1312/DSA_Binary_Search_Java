package binarysearch.easy;

/**
 * 
 * CodingNinjas: Square Root of a number
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/square-root-integral_893351
 * 
 * TC: O(log(N))
 * SC: O(1)
 * 
 */
public class P6_Find_Square_Root_Of_Number {
    public static void main(String[] args) {
        long n = 7;
        int sqRoot = sqrtN(n);
        System.out.println("Square Root of number " + n + " is : " + sqRoot);
    }

    public static int sqrtN(long N) {
        if (N == 0 || N == 1) {
            return (int) N;
        }
        long start = 1L;
        long end = N / 2;
        int sqrt = 1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= N) {
                if (mid > sqrt) {
                    sqrt = (int) mid;
                }
                start = mid + 1;
            } else if (mid * mid > N) {
                end = mid - 1;
            }
        }
        return sqrt;
    }
}
