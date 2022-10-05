package LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintLongestDivisbleSubset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6};
        List<Integer> ans=largestDivisibleSubset(arr);
        System.out.println(ans);

    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp=new int[nums.length];
        return constructLDS(nums,dp,getLDSsize(nums,dp));
    }

    public static int getLDSsize(int[] nums,int[] dp){
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int ldsSize=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ldsSize=Math.max(ldsSize,dp[i]);
                }
            }
        }
        return ldsSize;
    }


    public static List<Integer> constructLDS(int[] nums,int[] dp,int size){
        int prev=-1;
        LinkedList<Integer> lds=new LinkedList<>();

        for(int i=dp.length-1;i>=0;i--){
            if(dp[i]==size && (prev==-1 || prev%nums[i]==0)){
                lds.addFirst(nums[i]);
                size--;
                prev=nums[i];
            }
        }
        return lds;
    }
}
