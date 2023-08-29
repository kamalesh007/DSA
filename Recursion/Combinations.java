// Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.

// Make sure the combinations are sorted.

// To elaborate,

// Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
// Entries should be sorted within themselves.
// WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
public class Solution {
   
    public int[] factArr;
    public int totalCombinations;
    public int[][] ans;
    public int count;
    public int[][] combine(int A, int B) {
    factArr= new int[11];
    factArr[0]=1;
    for(int i = 1; i < 11;i++)
    {
        factArr[i] = factArr[i-1]*i;
    } 

    int nr = factArr[A];

    long dr = factArr[B] * factArr[Math.abs(A-B)];

    int iDr = (int) dr;

    totalCombinations = nr / iDr;
    //System.out.print(totalCombinations+"\t");
    if(totalCombinations<1)
    {
        return new int[0][0];
    }

    ans = new int[totalCombinations][B];
    count = 0;    
    generatePermutations(0,A,new int[B],1);
    return ans;
    }

    void generatePermutations(int index,int A,int[] arr,int start)
    {
        if(index == arr.length && count < totalCombinations)
        {
            int[] shallowCopy = new int[arr.length];
            for(int j = 0 ; j < arr.length ; j++)
            {
                shallowCopy[j]=arr[j];
            }    
            ans[this.count] = shallowCopy;
            this.count++;
            return;
        }

        for(int i = start ; i <= A ; i++)
        {            
            arr[index] = i;
            generatePermutations(index+1,A,arr,i+1);
        }
    }
}
