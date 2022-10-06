package DpOnSquares;

public class CountOfSquareSubmatricsWithAllOnes {
    public static void main(String[] args){
        int[][] arr={{0,1,1,0},
                {1,1,1,0},
                {0,0,1,0}};
        int ans=countSquares(arr);
        System.out.println(ans);
    }

    private static int countSquares(int[][] arr) {
        int[][] dp=new int[arr.length][arr[0].length];

         for(int i=0;i<arr.length;i++){
             dp[i][0]=arr[i][0];
         }

         for(int i=0;i<arr[0].length;i++){
             dp[0][i]=arr[0][i];
         }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(arr[i][j]==0) dp[i][j]=0;
                else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }

            }
        }

        int sum=0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                sum+=dp[i][j];
            }
        }

        return sum;
    }
}
