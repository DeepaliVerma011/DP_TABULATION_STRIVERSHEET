package DpOnSquares;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangleAreaWithAllOnes {
    public static void main(String[] args){
        int[][] arr={{0,1,1},
                {1,1,1,},
                {0,1,1}};

        int ans=maximalRectange(arr);
        System.out.println(ans);
    }

    private static int maximalRectange(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;

        int ans=Integer.MIN_VALUE;
        int[] temp=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[j]=arr[i][j]!=0?1+temp[j]:0;
            }
            ans=Math.max(ans,largestRectangleArea(temp));
        }
        return ans;
    }

    private static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int ans=Integer.MIN_VALUE;
        int[] x1=prevSmaller(heights);
        int[] x2=nextSmaller(heights);

        for(int i=0;i<n;i++){
            int leftSmall=x1[i];
            int rightSmall=x2[i];

            int width=rightSmall-leftSmall-1;
            int area=heights[i]*width;
            ans=Math.max(area,ans);
        }
        return ans;
    }

    private static int[] nextSmaller(int[] heights) {
        int n=heights.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);

        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;

            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] prevSmaller(int[] heights) {
        int n=heights.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;

            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
