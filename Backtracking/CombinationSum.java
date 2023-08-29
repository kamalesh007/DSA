// Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

// The same repeated number may be chosen from A unlimited number of times.

// Note:

// 1) All numbers (including target) will be positive integers.

// 2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

// 3) The combinations themselves must be sorted in ascending order.

// 4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

// 5) The solution set must not contain duplicate combinations.
public class Solution {
   
    public int N;
    public ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
            //Collections.sort(A);
            ans=new ArrayList<ArrayList<Integer>>();
            HashSet<Integer> s=new HashSet<Integer>();
            ArrayList<Integer> uniqueElements=new ArrayList<Integer>();
            for(Integer i:A)
            {
                s.add(i);
            }
            for(Integer k:s)
            {
                uniqueElements.add(k);
            }
            Collections.sort(uniqueElements);
            N=uniqueElements.size();
            combinationSumSolver(0,new ArrayList<Integer>(),B,uniqueElements);
            return ans;      

    }

    public void combinationSumSolver(int index,ArrayList<Integer> currArr,int targetSum,ArrayList<Integer> ip)
    {
        if(index==N)
        {
            if(targetSum==0)
            {
                ans.add((ArrayList<Integer>)currArr.clone());
            }
            return ;
        }
        else
        {
            if(ip.get(index)<=targetSum)
            {
                currArr.add(ip.get(index));
                combinationSumSolver(index,currArr,targetSum-ip.get(index),ip);
                currArr.remove(currArr.size()-1);
                combinationSumSolver(index+1,currArr,targetSum,ip);
            }
            else
            {
                combinationSumSolver(index+1,currArr,targetSum,ip);
            }
            return ;
        }
    }

}
