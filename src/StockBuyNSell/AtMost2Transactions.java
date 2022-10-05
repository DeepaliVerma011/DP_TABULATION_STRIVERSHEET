package StockBuyNSell;

public class AtMost2Transactions {
    public static void main(String args[]) {

        int n =8;
        int Arr[] = {3,3,5,0,0,3,1,4};

        System.out.println("The maximum profit that can be generated is "+getMaximumProfit(Arr, n));
    }

    private static int getMaximumProfit(int[] arr, int n) {
        int[][][] dp=new int[n][2][3];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }

            }
        }
        if(n==0) return 0;
        int ans=findprofit(arr,0,0,2,dp,n);
        return ans;
    }

    private static int findprofit(int[] arr, int i, int buy,int cap, int[][][] dp, int n) {
        if(i==n || cap==0) return 0;

        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;

        if(buy==0){
            profit=Math.max(0+findprofit(arr,i+1,0,cap,dp,n),-arr[i]+findprofit(arr,i+1,1,cap,dp,n));
        }

        if(buy==1){
            profit=Math.max(0+findprofit(arr,i+1,1,cap,dp,n),arr[i]+findprofit(arr,i+1,0,cap-1,dp,n));
        }

        return dp[i][buy][cap]=profit;
    }
}
