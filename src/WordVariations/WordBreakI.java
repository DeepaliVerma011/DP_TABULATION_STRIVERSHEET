package WordVariations;

import java.util.ArrayList;
import java.util.List;

public class WordBreakI {
    public static void main(String[] args){
      String s="leetcode";
      ArrayList<String> dictionary=new ArrayList<>();
      dictionary.add("leet");
      dictionary.add("code");
      boolean ans=checksCanBeSegmentedOrNot(s,dictionary);
      System.out.println(ans);
    }

    private static boolean checksCanBeSegmentedOrNot(String sentence, List<String> dictionary) {
        int[] dp=new int[sentence.length()];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                String w2Break=sentence.substring(j,i+1);

                if(dictionary.contains(w2Break)){
                    if(j>0){
                        dp[i]=dp[i]+dp[j-1];
                    }
                    else{
                        dp[i]=dp[i]+1;
                    }
                }
            }
        }

        return dp[sentence.length()-1]>0;
    }
}
