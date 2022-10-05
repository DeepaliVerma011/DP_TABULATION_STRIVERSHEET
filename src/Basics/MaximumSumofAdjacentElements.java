package Basics;

public class MaximumSumofAdjacentElements {
    public static void main(String[] args){
        int arr[]={2,1,4,9};
        int ans=findMaximumSum(arr);
        System.out.println(ans);
    }

    private static int findMaximumSum(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];


        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int pick=arr[i];
            if(i>1){
                pick+=dp[i-2];
            }

            int nonpick=0+dp[i-1];

            dp[i]=Math.max(pick,nonpick);
        }
        return dp[n-1];
    }
}
