package LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args){
        int[] arr={1,11,2,10,4,5,2,1};
        int ans=findbitonicSubsequence(arr);
        System.out.println(ans);
    }

    private static int findbitonicSubsequence(int[] arr) {
        int[] lis=new int[arr.length];
        int max=0;
        Arrays.fill(lis,1);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(arr[i]>arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    max = Math.max(lis[i], max);
                }
            }
        }
        int[] lds=new int[arr.length];
        int maxi=0;
        Arrays.fill(lds,1);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(arr[i]<arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                    maxi = Math.max(lds[i], maxi);
                }
            }
        }


        int omax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            omax=Math.max(lis[i]+lds[i]-1,omax);
        }
        return omax;
    }
}
