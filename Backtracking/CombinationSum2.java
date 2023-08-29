// Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

// Each number in A may only be used once in the combination.

// Note:

// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// Warning:

// DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

// Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.

public class Solution {
    public ArrayList<ArrayList<Integer>> ans;
    public int N;
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ans=new ArrayList<ArrayList<Integer>>();
        N=A.size();
        combinationSum(0,new ArrayList<Integer>(),B,A);
        return ans;
    }
    public void combinationSum(int index,ArrayList<Integer> currArray,int targetSum,ArrayList<Integer> A)
    {                        
        
        if(targetSum == 0 && !ans.contains(currArray))
            {
                ans.add((ArrayList<Integer>)currArray.clone());
                return ;
            }
        
        if(index == N)
        {            
            if(targetSum == 0 && !ans.contains(currArray))
            {
                ans.add((ArrayList<Integer>)currArray.clone());
            }

           
            return ;
        }
        if(A.get(index)<=targetSum)
        {
            currArray.add(A.get(index));
            combinationSum(index+1,currArray,targetSum-A.get(index),A);
            currArray.remove(currArray.size()-1);
            combinationSum(index+1,currArray,targetSum,A);
        }

        //combinationSum(index+1,currArray,targetSum,A);

    }
}
