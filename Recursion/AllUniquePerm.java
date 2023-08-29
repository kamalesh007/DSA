// Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

// NOTE: No 2 entries in the permutation sequence should be the same.

// WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
// Example : next_permutations in C++ / itertools.permutations in python.
// If you do, we will disqualify your submission retroactively and give you penalty points

public class Solution {
    
    public int[] factArr;
    public int[] freq ;
    public int totalPerumatations;
    public int[][] ans;
    int count;
    public int[][] permute(int[] A) {
        int len = A.length;
        freq = new int[11];
        factArr = new int[len+1];
        factArr[0]=1;
        for(int i = 1; i < len+1;i++)
        {
            factArr[i] = factArr[i-1]*i;
        }        

        for(int i = 0 ; i < len ;i++)
        {
            freq[A[i]]++;
            //System.out.print(freq[A[i]]+"\t");
        }

        int nr = factArr[len];

        int dr = 1;

        for(int i = 0 ; i < 11 ; i++)
        {
            if(freq[i]>1)
            {                
                dr *= factArr[freq[i]];
            }
        }
        totalPerumatations = nr / dr ;
        //System.out.print(totalPerumatations+"\t"+nr+"\t"+dr+"\t");
        ans = new int[totalPerumatations][len];
        count = 0;
        generateParantheses(0,len,new int[len]);
        return ans;
    }

    public void generateParantheses(int index,int len,int[] arr)
    {
        if(index == len)
        {
        
            int[] shallowCopy = new int[len];
            for(int j = 0 ; j < len ; j++)
            {
                shallowCopy[j]=arr[j];
            }    
            ans[this.count] = shallowCopy;
            this.count++;
            return;
        }
        for(int i = 0 ; i <= 10 ; i++)
        {
            if(freq[i]<=0)
            {
                continue;
            }
            arr[index] = i;
            freq[i]--;
            generateParantheses(index+1,len,arr);
            freq[i]++;
        }

    } 
    
}
