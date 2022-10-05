package LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int getAns(int arr[], int n,  int ind, int prev_index,int[][] dp){

        // base condition
        if(ind == n)
            return 0;

        if(dp[ind][prev_index+1]!=-1)
            return dp[ind][prev_index+1];

        int notTake = 0 + getAns(arr,n,ind+1,prev_index,dp);

        int take = 0;

        if(prev_index == -1 || arr[ind] > arr[prev_index]){
            take = 1 + getAns(arr,n,ind+1,ind,dp);
        }

        return dp[ind][prev_index+1] = Math.max(notTake,take);
    }

    static int longestIncreasingSubsequence(int arr[], int n){
        // n for current index which starts from 1
        //n+1 for previous index which starts from -1
        int dp[][]=new int[n][n+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return getAns(arr,n,0,-1,dp);
    }

    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is "
                +longestIncreasingSubsequence(arr,n));

    }
}
