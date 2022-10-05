package Basics;

public class Frogjump {
    public static void main(String[] args){
        int height[]={30,10,60,10,60,50};

        int ans=findEnergy(height);
        System.out.println(ans);
    }

    private static int findEnergy(int[] height) {
        int n=height.length;
        int[] dp=new int[n];

        dp[0]=1;

        for(int i=1;i<=dp.length;i++){
            //same as previous ques just we are adding absolute differnce of heights and finding minimum
            int jumpOne=dp[i-1]+Math.abs(height[i]-height[i-1]);

            int jumpTwo=Integer.MAX_VALUE;
            if(i>1){
                jumpTwo=dp[i-2]+Math.abs(height[i]-height[i-2]);
            }

            dp[i]=Math.min(jumpOne,jumpTwo);
        }
        return dp[n-1];
    }
}
