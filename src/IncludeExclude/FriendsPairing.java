package IncludeExclude;

public class FriendsPairing {
    public static void main(String[] args){
        int n=4;
        int ans=findWaysToStaySingleOrPairUp(n);
        System.out.println(ans);
    }

    private static int findWaysToStaySingleOrPairUp(int n) {
        int[] dp=new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            //stay single + pairup with (i-1)other people with dp[i-2] ways *(i-1)
            dp[i]=dp[i-1]+dp[i-2]*(i-1);
        }

        return dp[n];
    }


}
