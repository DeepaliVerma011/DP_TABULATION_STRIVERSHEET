package subsequence;

import java.util.Arrays;

public class RodCutting {

    static int cutRod(int[] price,int N) {

        int dp[][]=new int[N][N+1];

        for(int row[]:dp)
            Arrays.fill(row,-1);

        for(int i=0; i<=N; i++){
            dp[0][i] = i*price[0];
        }

        for(int ind=1; ind<N; ind++){
            for(int length =0; length<=N; length++){

                int notTaken = 0 + dp[ind-1][length];

                int taken = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength <= length)
                    taken = price[ind] + dp[ind][length-rodLength];

                dp[ind][length] = Math.max(notTaken,taken);
            }
        }

        return dp[N-1][N];
    }


    public static void main(String args[]) {

        int price[] = {2,5,7,8,10};

        int n = price.length;

        System.out.println("The Maximum price generated is "+cutRod(price,n));
    }
}
