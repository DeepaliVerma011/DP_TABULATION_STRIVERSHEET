package LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {
    public static void main(String[] args){
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }
    public static int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b)->a.length()-b.length());

        HashMap<String,Integer> dp=new HashMap<>();

        int ans=0;
        for(String word:words){
            int longestChainWithCurrentWord=0;
            for(int i=0;i<word.length();i++){
                String pred=word.substring(0,i)+word.substring(i+1,word.length());

                longestChainWithCurrentWord=Math.max(longestChainWithCurrentWord,dp.getOrDefault(pred,0)+1);

                dp.put(word,longestChainWithCurrentWord);

                ans=Math.max(ans,longestChainWithCurrentWord);
            }
        }

        return ans;
    }
}
