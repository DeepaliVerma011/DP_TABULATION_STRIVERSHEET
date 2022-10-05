package GridDP;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    static int mazeObstaclesUtil(int n, int m, int[][] maze, int[][] dp) {
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){

                //base conditions
                if(i>0 && j>0 && maze[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }

                int up=0;
                int left = 0;

                if(i>0)
                    up = dp[i-1][j];
                if(j>0)
                    left = dp[i][j-1];

                dp[i][j] = up+left;
            }
        }

        return dp[n-1][m-1];

    }

    static int mazeObstacles(int n, int m, int[][] maze){
        int dp[][]=new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return mazeObstaclesUtil(n,m,maze,dp);

    }

    public static void main(String args[]) {

        int[][] maze = { {0,0,0},
                {0,-1,0},
                {0,0,0}};

        int n = maze.length;
        int m = maze.length;

        System.out.println(mazeObstacles(n,m,maze));
    }
}
