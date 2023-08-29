// Given a positive integer A. Return an array of minimum length whose elements represent the powers of 3, and the sum of all the elements is equal to A.
public class Solution {
    public int[] solve(int A) {
    
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int pow = 0;
        while(A > 0)
        {
            int remainder = A % 3;
            A = A / 3;
            int powOf3 = (int)Math.pow(3,pow++);
            for(int i = 0 ; i < remainder ; i ++)
            {
                ans.add(powOf3);
            }
        }   
        int[] arr = new int[ans.size()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=ans.get(i);
        }
        return arr;
    
    }
}
