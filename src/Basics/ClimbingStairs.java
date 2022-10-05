package Basics;

public class ClimbingStairs {
    public static void main(String[] args){
        int n=3;
        int ans=findWaystoreachNth(n);
        System.out.println(ans);
    }

    private static int findWaystoreachNth(int n) {

        //why are we making dp of n+1 length?
        //because we are at 0th stair initially and want to go to nth floor
        //lets understand with a example
        //let say we have n=4
        // so we have traverse 0 1 2 3 4 which itself are 5 number of stair hence we will be making dp of 5(n+1) size
        int[] dp=new int[n+1];

        //here dp[i] means number of ways to reach ith floor

        //there is 1 way can reach 0th floor by staying at 0th stair hence we can fill 1 here.
        dp[0]=1;

        //to reach 1st stair we have only 1 way 1->0
        dp[1]=1;

        //as we can take one step/ two steps jump from each stair
        //hence we are adding past 2 no of ways
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
