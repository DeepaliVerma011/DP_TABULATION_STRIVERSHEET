package GridDP;

public class minSumPath {
    public static void main(String args[]) {

        int matrix[][] = {{5,9,6},{11,5,2}};

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(minPath(n,m,matrix));
    }

    private static int minPath(int n, int m, int[][] matrix) {


        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=matrix[i][j];
                }
                else{
                    int up=matrix[i][j];
                    if(i>0){
                        up+=dp[i-1][j];
                    }
                    int down=matrix[i][j];

                    if(j>0){
                        down+=dp[i][j-1];
                    }
                    dp[i][j]=Math.min(up,down);
                }

            }
        }
        return dp[n-1][m-1];
    }
}
