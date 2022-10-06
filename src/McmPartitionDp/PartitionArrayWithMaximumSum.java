package McmPartitionDp;

public class PartitionArrayWithMaximumSum {
    public static void main(String[] args){
       int[] arr={1,15,7,9,2,5,10};
       int k=3;
       int ans=findans(arr,k);
       System.out.println(ans);
    }

    private static int findans(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];

        for(int i=n-1;i>=0;i--){
            int len=0;
            int maxi=Integer.MIN_VALUE;
            int maxAnd=Integer.MIN_VALUE;
            int sum;

            for(int j=i;j<Math.min(n,i+k);j++){
                len++;
                maxi=Math.max(maxi,arr[j]);
                sum=(len*maxi)+dp[j+1];
                maxAnd=Math.max(maxAnd,sum);
            }
            dp[i]=maxAnd;
        }
        return dp[0];
    }
}
