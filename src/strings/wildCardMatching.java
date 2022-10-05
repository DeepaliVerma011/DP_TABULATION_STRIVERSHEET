package strings;

public class wildCardMatching {
    static boolean isAllStars(String S1, int i) {

        // S1 is taken in 1-based indexing
        for (int j = 1; j <= i; j++) {
            if (S1.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    static boolean wildcardMatching(String S1, String S2) {

        int n = S1.length();
        int m = S2.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(S1, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {



                //ya to strings same ho ya fir ? ho
                if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else {
                    //other wise star h to ya to use consider kre ya ni
                    if (S1.charAt(i - 1) == '*')
                        //i-1 jab hum consider ni kre || j-1 jab hum kre h
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

                    else dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String args[]) {

        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2))
            System.out.println("String S1 and S2 do match");
        else System.out.println("String S1 and S2 do not match");
    }

}
