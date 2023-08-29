// Given an integer A.
// Two numbers, X and Y, are defined as follows:

// X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
// Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
// Find and return the XOR of X and Y.

// NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

// NOTE 2: Your code will be run against a maximum of 100000 Test Cases.

public class Solution {
    public int solve(int A) {
    
    int X = 0;
    int Y = 0;
    int lastSetBit = -1;


    for(int i = 0 ; i < 31 ; i++)
    {
        if( (((1<<i) & A) == 0) && ((X | (1 << i))<A)) //Unset
        {
            X = X | (1 << i);
        }
        else if(((1<<i) & A) != 0)
        {
            lastSetBit = i;
        } 
    }

    

    Y = Y | (1 << lastSetBit+1);

    //System.out.print(X+"\t"+Y+"\t"+lastSetBit+"\t");

    //System.out.print(X+"\t"+Y+"\t");

    return X ^ Y;
    


    }
}
