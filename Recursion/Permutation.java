// Given an integer array A of size N denoting collection of numbers , return all possible permutations.

// NOTE:

// No two entries in the permutation sequence should be the same.
// For the purpose of this problem, assume that all the numbers in the collection are unique.
// Return the answer in any order
// WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
// Example : next_permutations in C++ / itertools.permutations in python.
// If you do, we will disqualify your submission retroactively and give you penalty points.
public class Solution {
    public int[][] ans;
    public int count;
    public int[][] permute(int[] A) {
    
    int N = A.length;

    int noOfPermutations = 1;

    for(int i = 2 ; i <= N ; i++)
    {
        noOfPermutations = noOfPermutations * i;
    }

    ans = new int[noOfPermutations][N];
    count = 0;
    boolean[] vst = new boolean[N];
    Arrays.fill(vst,false);
    permuteArray(vst,0,A,new int[N]);
    return ans;
    }

    public void permuteArray(boolean[] vst,int index,int[] A,int[] arr)
    {
        // Base cases
        if(index == A.length)
        {
            //ans[count++] = arr;
            int[] temp = new int[A.length]; 
            for(int i = 0 ; i < A.length ; i++)
            {
                temp[i] = arr[i];
            }
            ans[count++] = temp;
            return;
        }

        for(int i = 0 ; i < A.length ; i++) // All Possibilites
        {
            if(vst[i] == false) // Valid Possibilites
            {
                vst[i] = true;
                arr[index] = A[i];
                permuteArray(vst,index+1,A,arr);
                vst[i] = false;
            }
        }
        return;

    }
}
