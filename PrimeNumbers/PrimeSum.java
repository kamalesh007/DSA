// Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

// If there is more than one solution possible, return the lexicographically smaller solution.

// If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
// [a, b] < [c, d], If a < c OR a==c AND b < d. 
// NOTE: A solution will always exist. Read Goldbach's conjecture.

public class Solution {
    public int[] primesum(int A) {
    
        int[] seiveArr = new int[A+1];

        for(int i = 0 ; i <= A; i++)
        {
            seiveArr[i] = 1;
        }

        seiveArr[0] = 0;
        seiveArr[1] = 0;

        for(int i = 2 ; i * i <= A ; i++)
        {
            if(seiveArr[i] == 1)
            {
                for(int j = i*i ; j <= A; j+=i)
                {
                    seiveArr[j] = 0;
                }
            }
        }

        for(int i = 2 ; i <= A ; i++)
        {
            if(seiveArr[i]==1 && seiveArr[A-i] ==1)
            {
                int[] ans=new int[2];
                ans[0] = i;
                ans[1] = A-i;
                return ans;
            }
        }
        return new int[]{};
    
    }
}
