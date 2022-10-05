package strings;

public class editDistance {
    static int editDistance(String S1, String S2){

        int n = S1.length();
        int m = S2.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(S1.charAt(i-1)==S2.charAt(j-1))
                    dp[i][j] = 0+dp[i-1][j-1];
                 //else operation required
                else dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {

        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: "+
                editDistance(s1,s2));
    }
}
