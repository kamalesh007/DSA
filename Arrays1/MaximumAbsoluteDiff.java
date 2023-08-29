// You are given an array of N integers, A1, A2, .... AN.

// Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
public class Solution {
    public int maxArr(int[] A) {
        int Xmax=Integer.MIN_VALUE;
        int Ymax=Integer.MIN_VALUE;
        int Xmin=Integer.MAX_VALUE;
        int Ymin=Integer.MAX_VALUE;
        int[] X=new int[A.length];
        int[] Y=new int[A.length];
        
        for(int i=0;i<A.length;i++)
        {
            X[i]=A[i]+i;
            Y[i]=A[i]-i;
        }
        
        for(int i=0;i<X.length;i++)
        {
            if(X[i]>Xmax)
            {
                Xmax=X[i];
            }
            if(Y[i]>Ymax)
            {
                Ymax=Y[i];
            }
        }
        for(int i=0;i<X.length;i++)
        {
            if(X[i]<Xmin)
            {
                Xmin=X[i];
            }
            
            if(Y[i]<Ymin)
            {
                Ymin=Y[i];
            }
        }
        return Math.max(Xmax-Xmin,Ymax-Ymin);
        
        
    }
}
