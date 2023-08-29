// Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
// Find the two integers that appear only once.

// Note: Return the two numbers in ascending order.

public class Solution {
    public int[] solve(int[] A) {
        int xor=0;
        for(int i=0;i<A.length;i++)
        {
            xor=xor^(A[i]);
        }
        int bit=0;
        for(int i=0;i<=31;i++)
        {
            int shift=1<<i;
            if((shift & xor)!=0)
            {
                bit=i;
                break;
            }
        }
        
        //System.out.print(xor+" "+bit+"\t");
        
        int xorA=0;
        int xorB=0;
        
        for(int i=0;i<A.length;i++)
        {
            if((A[i] & (1<<bit)) != 0)
            {
                xorA=xorA^(A[i]);
            }
            else
            {
                xorB=xorB^(A[i]);
            }
        }
        
        int[] arr=new int[2];
        if(xorA>xorB)
        {
            arr[0]=xorB;
            arr[1]=xorA;
        }
        else
        {
            arr[0]=xorA;
            arr[1]=xorB;
        }
        return arr;
    }
}
