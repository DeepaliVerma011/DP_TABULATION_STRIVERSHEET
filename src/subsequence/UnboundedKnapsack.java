package subsequence;

public class UnboundedKnapsack {
    static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {

        int[][] dp=new int[n][W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = 0 + dp[ind-1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }

    public static void main(String args[]) {

        int wt[] = {2,4,6};
        int val[] = {5,11,13};
        int W=10;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "
                +unboundedKnapsack(n,W,val,wt));
    }
}
