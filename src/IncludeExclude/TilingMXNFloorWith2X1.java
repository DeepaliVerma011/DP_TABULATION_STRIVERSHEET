package IncludeExclude;

public class TilingMXNFloorWith2X1 {
    public static void main(String[] args){
        int n=39;
        int m=16;
        int ans=findWays(n,m);
        System.out.println(ans);
    }

    private static int findWays(int n, int m) {
        int[] dp=new int[n+1];

        for(int i=1;i<=n;i++){
            if(i<m){
                dp[i]=1;
            }
            else if(i==m){
                dp[i]=2;
            }
            else{
                dp[i]=dp[i-1]+dp[i-m];
            }
        }
        return dp[n];
    }
}
