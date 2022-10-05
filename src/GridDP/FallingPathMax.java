package GridDP;

public class FallingPathMax {
    static int getMaxPathSum(int[][] matrix){

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing first row - base condition
        for(int j=0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i<n; i++){
            for(int j=0;j<m;j++){

                int up = matrix[i][j] + dp[i-1][j];

                int leftDiagonal= matrix[i][j];
                if(j-1>=0) leftDiagonal += dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(-10,9);

                int rightDiagonal = matrix[i][j];
                if(j+1<m) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(-10,9);

                dp[i][j] = Math.max(up, Math.max(leftDiagonal,rightDiagonal));

            }
        }

        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<m;j++){
            maxi = Math.max(maxi,dp[n-1][j]);
        }

        return maxi;
    }

    public static void main(String args[]) {

        int matrix[][] = {{1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1}};

        System.out.println(getMaxPathSum(matrix));
    }
}
