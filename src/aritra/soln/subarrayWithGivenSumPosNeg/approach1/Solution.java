package aritra.soln.subarrayWithGivenSumPosNeg.approach1;

import java.util.Scanner;

public class Solution {
    //Test Data
    static int  numOfTestCases = 3;
    static int[] lengthOfArrays = {3,8,4};
    static int[][] arrays = {
                        {1,2,3},
                        {-2, -3, 4, -1, -2, 1, 5, -3},
                        {-1,-2,-3,-4}
                     };
    public static void main(String[] args){
        //Manual data entry
        //initTestData();

        //Automatic test data
        for(int i = 0; i < numOfTestCases; i++){
            System.out.println(findMaxSum(lengthOfArrays[i], arrays[i]));
        }
    }

    public static int findMaxSum(int N, int[] array){
        //Using Kadane's Algorithm
        int max_upto_this_point = array[0];
        int max_so_far = array[0];
        for(int i = 1; i < N; i++){
            max_upto_this_point += Math.max(array[i],max_upto_this_point + array[i]);
            if(max_upto_this_point > max_so_far){
                max_so_far = max_upto_this_point;
            }
            if(max_upto_this_point < 0) {
                max_upto_this_point = 0;
            }
        }
        return max_so_far;
    }

    public static void initTestData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        numOfTestCases = sc.nextInt();
        while(numOfTestCases-- > 0){
            System.out.println("Enter length of array:");
            int lengthOfArray = sc.nextInt();
            int[] arrayContent = new int[lengthOfArray];
            int i = 0;
            while(i < lengthOfArray){
                System.out.println("Enter element value:");
                arrayContent[i++] = sc.nextInt();
            }
            System.out.println("The max sum = " + findMaxSum(lengthOfArray,arrayContent));
        }
    }
}
