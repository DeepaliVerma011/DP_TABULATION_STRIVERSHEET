package IncludeExclude;

public class Tiling2XNFloorWith2X1 {
    public static void main(String[] args){
        int n=8;
        int ans=findWaystoTile(n);
        System.out.println(ans);
    }

    private static int findWaystoTile(int n) {
        int[] dp=new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
