package codility;

/**
 * Created by eduardopinto on 22/10/16.
 *
 * You are given N counters, initially set to 0, and you have two possible operations on them:

 increase(X) − counter X is increased by 1,
 max counter − all counters are set to the maximum value of any counter.
 A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

 if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 if A[K] = N + 1 then operation K is max counter.
 For example, given integer N = 5 and array A such that:

 A[0] = 3
 A[1] = 4
 A[2] = 4
 A[3] = 6
 A[4] = 1
 A[5] = 4
 A[6] = 4
 the values of the counters after each consecutive operation will be:

 (0, 0, 1, 0, 0)
 (0, 0, 1, 1, 0)
 (0, 0, 1, 2, 0)
 (2, 2, 2, 2, 2)
 (3, 2, 2, 2, 2)
 (3, 2, 2, 3, 2)
 (3, 2, 2, 4, 2)
 The goal is to calculate the value of every counter after all operations.

 Write a function:

 class Solution { public int[] solution(int N, int[] A); }
 that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

 The sequence should be returned as:

 a structure Results (in C), or
 a vector of integers (in C++), or
 a record Results (in Pascal), or
 an array of integers (in any other programming language).
 For example, given:

 A[0] = 3
 A[1] = 4
 A[2] = 4
 A[3] = 6
 A[4] = 1
 A[5] = 4
 A[6] = 4
 the function should return [3, 2, 2, 4, 2], as explained above.

 Assume that:

 N and M are integers within the range [1..100,000];
 each element of array A is an integer within the range [1..N + 1].
 Complexity:

 expected worst-case time complexity is O(N+M);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {

        int[] counters = new int[N];

        int reset = 0, max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > N)
                reset = max;

            else {
                if (counters[A[i]-1] < reset) {
                    counters[A[i]-1] = reset;
                }

                counters[A[i]-1]++;
                if (counters[A[i]-1] > max)
                    max = counters[A[i]-1];
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < reset)
                counters[i] = reset;
        }

        for (int i = 0; i < counters.length; i++) {
            System.out.println(counters[i]);
        }

        return counters;
    }

    public static void main(String[] args) {
        MaxCounters e = new MaxCounters();
        e.solution(5, new int[]{3,4,4,6,1,4,4});
        System.out.println("#\n\n");
        e.solution(4, new int[]{4,4,4,4,4,4,4,5,3,3,2,2,2,3,6,2,2,3,5,2,2,1,5,2});

        // (1,[1,2,3]) = [1]
        // (1,[1]) = [1]
        // (1,[5]) = [0]
        // (1,[1,1,1,2,3]) = 3
        // (2,[1,1,1,2,3,1]) = [4,3]
        // (5, [3, 4, 4, 5, 1, 4, 4]) = (1, 0, 1, 4, 1)
    }
}
