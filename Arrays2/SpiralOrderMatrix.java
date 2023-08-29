public class Solution {
    public int[][] generateMatrix(int A) {
    int[] [] ans = new int[A][A];

    int start_value = 1;

    int topRow = 0;

    int bottomRow = A - 1;

    int rightCol = A - 1;

    int leftCol = 0;

    while(topRow < bottomRow && leftCol < rightCol) // topRow <= bottomRow && leftCol <= rightCol also correct middle element will be set but unecessary loops
    {
         for(int i = leftCol ; i <= rightCol ; i++)
        {
            ans[topRow][i] = start_value++;
        }

        topRow ++;

        for(int i = topRow ; i <= bottomRow ; i++)
        {
            ans[i][rightCol] = start_value++;
        }
        rightCol -- ;

        for(int i = rightCol ; i >= leftCol ; i-- )
        {
            ans[bottomRow][i] = start_value ++;
        }

        bottomRow -- ;

        for(int i = bottomRow ; i >= topRow ; i --)
        {
            ans[i][leftCol] = start_value ++;
        }

        leftCol ++;
    }
    
    if((A & 1 )== 1)
    {
        ans[A >> 1][A >> 1] = start_value++; // Setting middle element if A i
    }

    return ans;
   


    
    }
}
