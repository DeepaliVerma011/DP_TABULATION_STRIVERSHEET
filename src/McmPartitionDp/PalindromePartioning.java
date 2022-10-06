package McmPartitionDp;

public class PalindromePartioning {
    public static void main(String[] args){
        String s="ABC";
        int ans=findpartitions(s);
        System.out.println("The minimum Number of partitions of make all parts palindrome"+ ans);
    }

    private static int findpartitions(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int g=1;g<dp.length;g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                if(checkPalindrome(s,i,j)){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][j],1+dp[i][k]+dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public static boolean checkPalindrome(String s,int i,int j){


        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
