package McmPartitionDp;

public class MatrixChainMultiplication {
    public static void main(String args[]) {

        int arr[] = {10, 20, 30, 40, 50};

        int n = arr.length;

        System.out.println("The minimum number of operations are "+
                matrixMultiplication(arr,n));

    }

    private static int matrixMultiplication(int[] arr, int n) {
        int[][] dp=new int[n][n];

        for(int len=2;len<n;len++){
            for(int row=0,col=len;row<n-len;row++,col++){
                dp[row][col]=Integer.MAX_VALUE;
                //breaks
                for(int k=row+1;k<col;k++){
                    //left +right +combine
                    dp[row][col]=Math.min(dp[row][col],dp[row][k]+dp[k][col]+arr[row]*arr[k]*arr[col]);
                }

            }

        }
        return dp[0][n-1];

    }

}
