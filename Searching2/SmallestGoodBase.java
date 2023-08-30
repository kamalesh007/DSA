// Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A, you should return the smallest good base of A in string format.
public class Solution {
    public String solve(String A) {
        /*
        *Min we can get 2 1's or max we can get logbase2(10 pow 18) = 63
        Fix the number of 1's 
        Now for this try find whether for that number of 1's is there any good base between 2-N-1; 
        */
        Long input = Long.parseLong(A);
        Long ans= input-1;
        for(int noOf1 = 62 ; noOf1 >= 3 ; noOf1--)
        {            
            Long base = findGoodBase(noOf1,input);            
            if(base != -1 )
            {
                return base+"";
            }
        }
        return ans +"";
    }

    public long findGoodBase(int noOf1,Long input)
    {
        long low = 2;
        long high = input - 1;
        while(low <= high)
        {
            long currentBase = low + ((high - low)/2);
            long currentBasePow1s=1; // K pow M
            long nr= 1;
            long dr= 1;
            long nr_dr=nr/dr;
            for(int i=1;i<=noOf1;i++)
            {
                currentBasePow1s = currentBasePow1s * currentBase;
                nr=currentBasePow1s - 1;
                dr = currentBase - 1;
                nr_dr = nr/dr;
                if(nr_dr >  input)
                {
                    break;
                }

            }            
            if(nr_dr >input)
            {
                high = currentBase - 1;
            }
            else if(nr_dr<input)
            {
                low = currentBase + 1;                
            }
            else
            {
                return currentBase;
            }


        }
        return -1;

    }


    
}
