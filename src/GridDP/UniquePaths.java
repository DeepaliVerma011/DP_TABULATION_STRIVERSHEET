package GridDP;

public class UniquePaths {
    public static void main(String[] args){
        int m=3;
        int n=2;

        int ans=findans(m,n);
        System.out.println(ans);
    }

    private static int findans(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                    continue;
                }
                int up=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                int left=0;
                if(j>0){
                    left=dp[i][j-1];
                }

                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
