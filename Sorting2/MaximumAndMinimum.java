// Given an array of integers A of size N where N is even.

// Divide the array into two subsets such that

// 1.Length of both subset is equal.
// 2.Each element of A occurs in exactly one of these subset.
// Magic number = sum of absolute difference of corresponding elements of subset.

// Note: You can reorder the position of elements within the subset to find the value of the magic number.

// For Ex:- 
// subset 1 = {1, 5, 1}, 
// subset 2 = {1, 7, 11}
// Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
// Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
public class Solution {
    public int[] solve(int[] A) {
        int mod = 1000000000+7;
        long  maxMagic = 0 ;
        int minMagic = 0 ;
        Arrays.sort(A);

        int i = 0 ;
        int j = A.length -1 ;
        while(i < (A.length/2))
        {
            
            maxMagic = (maxMagic + Math.abs(A[i]-A[j])) % mod;
           // maxMagic += (Math.abs(A[i] - A[j]) % mod);
            j--;
            i++;
        }
        
        for(i = 0 ; i < A.length - 1 ; i+=2)
        {
            minMagic += (Math.abs(A[i]-A[i+1]) % mod);
        }
        return new int[]{(int)maxMagic,minMagic};
    }
}
