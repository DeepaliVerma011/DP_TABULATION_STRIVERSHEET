package IncludeExclude;

public class CountBinaryString_LengthNWithNoConsecutiveZeros {
    public static void main(String[] args){
        int n=6;
        int ans=findAns(n);
        System.out.println(ans);
    }

    private static int findAns(int n) {

        int stringendingwith1Old=1;
        int stringendingwith0Old=1;

        for(int i=2;i<=n;i++){
            int stringendingwith1new=stringendingwith1Old+stringendingwith0Old;
            int stringendingwith0new=stringendingwith1Old;

            stringendingwith0Old=stringendingwith0new;
            stringendingwith1Old=stringendingwith1new;
        }
        return stringendingwith0Old+stringendingwith1Old;
    }
}
