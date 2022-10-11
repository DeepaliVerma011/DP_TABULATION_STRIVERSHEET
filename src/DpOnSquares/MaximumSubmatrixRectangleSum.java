package DpOnSquares;

public class MaximumSubmatrixRectangleSum {

    public static void main(String[] args){
        int[][] arr={{1,2,-1,-4,-20},{-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}};
        int ans=maximumSumRectangle(4,5,arr);
        System.out.println(ans);
    }
    static int kadane(int[] arr){
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            maxsum = Math.max(sum,maxsum);
            if(sum<0){
                sum = 0;
            }
        }
        return maxsum;
    }
    static int maximumSumRectangle(int R, int C, int M[][]) {
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0;i<C;i++){
            int[] tmp = new int[R];
            for(int j=i;j<C;j++){
                for(int k = 0;k<R;k++){
                    tmp[k]+=M[k][j];
                }
                int sum = kadane(tmp);
                if(sum>maxsum){
                    maxsum = sum;
                }
            }
        }
        return maxsum;
    }
}
