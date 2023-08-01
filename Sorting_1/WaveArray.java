public class Solution {
    public int[] wave(int[] A) {
    
        // Sort and inte

        Arrays.sort(A);
        
        int i=0;
        
        while((i+1)<A.length)
        {
            int temp=A[i];
            A[i]=A[i+1];
            A[i+1]=temp;
            i=i+2;
            
        }

        return A;
        
        
        
        
        // for(int i=0;i<A.length;i++)
        // {
         
        //     if((i+1)<A.length)
        //     {
        //         int temp=A[i];
        //         A[i]=A[i+1];
        //         A[i+1]=temp;
        //     }
         
        // }
        //return A;
    }
}
