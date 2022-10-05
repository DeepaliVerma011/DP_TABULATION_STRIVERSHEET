package StockBuyNSell;

public class InfiniteTransactionWithTransactionFee {
    public static void main(String args[]) {

        int n =6;
        int Arr[] = {1,3,2,8,4,9};
        int fee=2;
        System.out.println("The maximum profit that can be generated is "+getMaximumProfit(Arr, n,fee));
    }

    private static int getMaximumProfit(int[] arr, int n,int fee) {
        int[][] dp=new int[n][2];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        if(n==0) return 0;
        int ans=findprofit(arr,0,0,fee,dp,n);
        return ans;
    }

    private static int findprofit(int[] arr, int i, int buy,int fee, int[][] dp, int n) {
        if(i==n) return 0;

        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;

        if(buy==0){
            profit=Math.max(0+findprofit(arr,i+1,0,fee,dp,n),-arr[i]+findprofit(arr,i+1,1,fee,dp,n));
        }

        if(buy==1){
            profit=Math.max(0+findprofit(arr,i+1,1,fee,dp,n),arr[i]-fee+findprofit(arr,i+1,0,fee,dp,n));
        }

        return dp[i][buy]=profit;
    }
}
