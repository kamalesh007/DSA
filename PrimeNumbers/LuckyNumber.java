// A lucky number is a number that has exactly 2 distinct prime divisors.

// You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
public class Solution {
    public int solve(int A) {
    
    int[] seiveArr = new int[A+1];
    for(int i =0 ;i<=A;i++)
    {
        seiveArr[i] = -1;
    }
    
    seiveArr[0]= 0;
    seiveArr[1] =0;

    for(int i = 2 ;i <= A/2;i++)
    {
        if(seiveArr[i] == -1)
        {
            for(int j = 2*i ; j <= A; j+= i)
            {
                if(seiveArr[j]== -1)
                {
                    seiveArr[j]=1;
                }
                else
                {
                    seiveArr[j]++;
                }
            }
        }
    }
    int ans =0;
    for(int i = 0 ; i <= A ;i++)
    {
        if(seiveArr[i] == 2)
        {
            ans++;
        }
    }
    return ans;

    }
}
