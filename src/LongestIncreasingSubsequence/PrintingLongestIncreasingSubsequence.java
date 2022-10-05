package LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintingLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        List<Integer> ans=largestIncreasingSubset(arr);
        System.out.println(ans);

    }
    public static List<Integer> largestIncreasingSubset(int[] nums) {
        int[] dp=new int[nums.length];
        return constructLDS(nums,dp,getLISsize(nums,dp));
    }

    public static int getLISsize(int[] nums,int[] dp){
        Arrays.fill(dp,1);
        int lisSize=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    lisSize=Math.max(lisSize,dp[i]);
                }
            }
        }
        return lisSize;
    }


    public static List<Integer> constructLDS(int[] nums,int[] dp,int size){
        int prev=-1;
        LinkedList<Integer> lis=new LinkedList<>();

        for(int i=dp.length-1;i>=0;i--){
            if(dp[i]==size && (prev==-1 || prev>nums[i])){
                lis.addFirst(nums[i]);
                size--;
                prev=nums[i];
            }
        }
        return lis;
    }
}
