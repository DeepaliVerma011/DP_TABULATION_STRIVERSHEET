package LongestIncreasingSubsequence;

import java.util.*;

public class PrintingAllLongestIncreasingSubsequence {
    public static class Pair{
        int length;
        int index;
        int value;
        String answersofar;

        Pair(int length,int index,int value,String answersofar){
            this.length=length;
            this.index=index;
            this.value=value;
            this.answersofar=answersofar;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        printAllLis(arr);

    }


    private static void printAllLis(int[] arr) {


        int n=arr.length;
        int[] lis=new int[arr.length];
        Arrays.fill(lis,1);
        int omax=0;
        int omaxi=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(arr[j]<arr[i]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                    if(lis[i]>omax){
                        omax=lis[i];
                        omaxi=i;
                    }
                }
            }
        }

        System.out.println("Length of Lis is "+omax);


        ArrayDeque<Pair> queue=new ArrayDeque<>();
        for(int i=0;i<lis.length;i++) {
            if(lis[i]==omax) {
                queue.add(new Pair(omax, i, arr[i], arr[i] + ""));
            }
        }
        ArrayList<String> savings=new ArrayList<>();

        while(!queue.isEmpty()){
            Pair removepair= queue.removeFirst();
            if(removepair.length==1){
                savings.add(removepair.answersofar);
                System.out.println(removepair.answersofar);
            }
            for(int j= removepair.index;j>=0;j--){
                if(lis[j]+1==lis[removepair.length] && arr[j]<arr[removepair.index]){
                    queue.add(new Pair(lis[j],j,arr[j],arr[j]+"->"+removepair.answersofar));
                }
            }
        }
        System.out.println("Count of No of Lis Possible is "+ savings.size());
    }
}
