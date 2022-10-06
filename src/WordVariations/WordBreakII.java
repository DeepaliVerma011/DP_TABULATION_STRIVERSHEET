package WordVariations;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
    public void main(String[] args){
        String s="leetcode";
        ArrayList<String> dictionary=new ArrayList<>();
        dictionary.add("leet");
        dictionary.add("code");
        List<String> ans=wordBreak(s,dictionary);
        System.out.println(ans);
    }
    public List<String> wordBreak(String s, List<String> dict) {
        List<String> ansList=new ArrayList<>();
        wordBreak(s,"",dict,ansList);
        return ansList;
    }

    public static void wordBreak(String s,String ans,List<String> dict,List<String> ansList){

        if(s.length()==0){
            ansList.add(ans.substring(0,ans.length()-1));
            return;
        }

        for(int i=0;i<s.length();i++){
            String left=s.substring(0,i+1);

            if(dict.contains(left)){
                String right=s.substring(i+1);
                wordBreak(right,ans+left+" ",dict, ansList);
            }
        }
    }
}
