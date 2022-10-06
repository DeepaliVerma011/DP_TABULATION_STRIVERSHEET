package strings;

public class PrintLongestCommonSubstring {
    public static void main(String args[]) {

        String s1= "abcjklp";
        String s2= "acjkp";
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        System.out.println("The Length of Longest Common Substring is "+lcsS(s1,s2,dp,lcs(s1,s2,dp)));
    }

    private static String lcsS(String s1, String s2, int[][] dp, int lcs) {

        String ans="";
        int i=s1.length();
        int j=s2.length();

        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans=ans+s1.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){

                    i--;
                }
                else{

                    j--;
                }
            }
        }
        String ans1 = reverse(ans);
        return ans1;
    }

    private static String reverse(String ans) {
        StringBuilder s=new StringBuilder(ans);
        s=s.reverse();
        return s.toString();
    }

    private static int lcs(String s1, String s2,int[][] dp) {
        int n=s1.length();
        int m=s2.length();


        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=0+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
