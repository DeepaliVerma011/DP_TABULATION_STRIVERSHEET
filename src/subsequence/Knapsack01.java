package subsequence;

public class Knapsack01 {
    public static void main(String args[]) {

        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "
                +knapsack(wt,val,n,W));
    }

    private static  int knapsack(int[] wt, int[] val, int n, int w) {
        int[][] dp=new int[n][w+1];

        for(int i=wt[0];i<=w;i++){
            dp[0][i]=val[0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=w;j++) {
                int take = Integer.MIN_VALUE;
                if (wt[i] <= w && j>wt[i]) {
                    take = dp[i - 1][j - wt[i]] + val[i];

                }
                int nontake = dp[i - 1][j];


                dp[i][j] = Math.max(take,nontake);
            }
        }
        return dp[n-1][w];
    }

}
