package aritra.soln.subarrayWithGivenSumPositive.approach1;

import java.util.Scanner;

/**
 * author: Aritra Chatterjee
 * Link -> https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 */
public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int numOfTestCases = 0;
        sc = new Scanner(System.in);
        numOfTestCases = sc.nextInt();

        while(numOfTestCases-- > 0){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int[] elemArr = new int[N];
            for(int i = 0; i < N; i++){
                elemArr[i] = sc.nextInt();
            }
            testSubarraySum(elemArr,N,S);
        }
    }

    public static void testSubarraySum(int[] elemArr,int N, int S){
        if(N < 1)
            return;
        int start = 0, i;
        int currentSum = elemArr[0];
        for(i = 1; i <= N; i++){
            while(currentSum > S && start < i - 1){
                currentSum -= elemArr[start];
                start++;
            }
            if(currentSum == S){
                System.out.println("Sum found between indexes " + start + " and " + (i - 1));
                return;
            }
            if(i < N)
                currentSum += elemArr[i];
        }
        System.out.println("-1");
    }
}
