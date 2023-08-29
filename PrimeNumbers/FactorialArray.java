// Groot has an array A of size N. However, seeking excitement, Groot embarked on constructing an equally-sized array B with a unique definition for each of its elements:

// B[i] = factorial of A[i] for every i such that 1<= i <= N.

// Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non-empty set of prime factors.

// Since the number can be huge, return it modulo 109 + 7.

// NOTE:

// Factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
// A set is a data structure having only distinct elements. E.g : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}

public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        int max=A[A.length-1];
        //HashSet<Integer> primes=
        long ans=0;
        int[] seive=new int[max+1];
        int arrPtr=0;
        for(int i=0;i<seive.length;i++)
        {
            seive[i]=1;
        }
        seive[0]=seive[1]=0;
        for(int i=2;i*i<=max;i++)
        {
            if(seive[i]==1)
            {
                for(int j=i*i;j<seive.length;j=j+i)
                {
                    seive[j]=0;
                }
            }
        }               
       while(A[arrPtr]==1) // 1 Doesnt have a prime factor
       {
           arrPtr++;
       }
        for(int i=2;i<=max;i++)
        {
            if(seive[i]==1)
            {
                int count=0;
                int lowerBound=i;
                int upperBound=max+1;
                for(int j=i+1;j<=max;j++)
                {
                    if(seive[j]==1)
                    {
                       upperBound=j;
                       break;
                    }
                }
                //Find count of elements lowerbound>= and <upperbound
                while(arrPtr< A.length && A[arrPtr]>=lowerBound && A[arrPtr]<upperBound)
                {
                    count++;
                    arrPtr++;
                }
                
                int contribution=this.fastExpo(2,count,1000000007)-1;
                // contribution+=1000000007;
                // contribution=contribution%1000000007;
                //System.out.print(contribution+" ");
                ans=(ans+contribution)%1000000007;
                
            }
        }
        //System.out.print(" ->");
        return (int)((ans)%1000000007);
    }
    
    public int fastExpo(int a,int b,int m)
    {
        long res=1L;
        while(b!=0)
        {
            if(b%2==0)
            {
                a=(a*a)%m;
                b=b/2;
            }
            else
            {
                res=(res*a)%m;
                a=(a*a)%m;
                b=b/2;
            }
        }
        return (int)res;
    }
}
