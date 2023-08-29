// Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

// Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
public class Solution {
    public int[] solve(int[] A) {
        Arrays.sort(A);
        int ptr=0;
        int[] ans=new int[(int)Math.sqrt(A.length)];
        HashMap<Integer,Integer> gcdPairs=new HashMap<Integer,Integer>();
        for(int i=A.length-1;i>=0;i--)
        {
            int x=A[i];

            if(gcdPairs.containsKey(x) && gcdPairs.get(x)>0)
            {
                int count=gcdPairs.get(x);
                gcdPairs.put(x,count-1);                
            }
            else
            {
                for(int j=0;j<ptr;j++)
                {
                    int gcd=gcdUtil(x,ans[j]);
                    if(gcdPairs.containsKey(gcd))
                    {
                        int update=gcdPairs.get(gcd);
                        gcdPairs.put(gcd,update+2);
                    }
                    else
                    {
                        gcdPairs.put(gcd,2);
                    }                    
                }
                ans[ptr++]=x;                
            }
        }
        return ans;
    }

    public static int gcdUtil(int a, int b) // A>B
    {
        if(b==0)return a;
        return gcdUtil(b,a%b);
    }
}
