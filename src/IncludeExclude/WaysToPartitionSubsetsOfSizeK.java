package IncludeExclude;

public class WaysToPartitionSubsetsOfSizeK {
    public static void main(String[] args){
        int n=4;
        int k=3;
        int ans=findWays(n,k);
        System.out.println(ans);
    }

    private static int findWays(int n, int k) {
        if(n==0 || k==0 || n<k){
            return 0;
        }

        int[][] dp=new int[k+1][n+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //3 logo ko 5 team mai kese bat sakte hai? =0
                if(i<j){
                    dp[i][j]=0;

                }
                //100 logo ko 100 team mai bathne ka tarika 1 hi hoga sabko alag alag team mai
                else if(i==j){
                    dp[i][j]=1;
                }
                //jab 3 ko 2 mai batna ho to valid question hai
                else{
                    //1-2 ->13-2 /1-23 2 possibilities
                    //12 -> 12-3 possibility
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1]*i;
                }
            }
        }
        return dp[k][n];
    }
}
