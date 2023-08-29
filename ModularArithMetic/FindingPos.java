// You are given an integer A which denotes the number of people standing in the queue.

// A selection process follows a rule where people standing on even positions are selected. Of the selected people, a queue is formed, and again out of these, only people on even position are selected.

// This continues until we are left with one person. Find and return the position of that person in the original queue.
public class Solution {
    public int solve(int A) {
        if(A==1)
            return 1;
        int ans=2;
        while(ans*2<=A)
        {
            ans=ans*2;
        }
        return ans;
        
    }
}
