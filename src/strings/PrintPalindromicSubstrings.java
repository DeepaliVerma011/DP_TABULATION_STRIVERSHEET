package strings;

import java.util.ArrayList;
import java.util.List;

public class PrintPalindromicSubstrings {
    public static void main(String[] args){
        String s="aaa";
        List<String> ans=printpalindromicSubstrings(s);
        System.out.println(ans);
    }
    public static List<String> printpalindromicSubstrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        List<String> ans=new ArrayList<>();
        int count=0;

        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }
                else if(g==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else{

                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) dp[i][j]=true;
                    else dp[i][j]=false;
                }

                if(dp[i][j]) ans.add(s.substring(i,j+1));
            }
        }
        return ans;
    }
}
