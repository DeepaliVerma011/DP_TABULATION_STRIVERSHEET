package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinctPalindromicSubstrings {
    public static void main(String[] args){
        String s="abaaa";
        HashSet<String> ans=printpalindromicSubstrings(s);
        System.out.println(ans);
    }
    public static HashSet<String> printpalindromicSubstrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        HashSet<String> ans=new HashSet<>();
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
