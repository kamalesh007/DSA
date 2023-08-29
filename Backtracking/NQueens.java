public class Solution {
	public int N;
    public ArrayList<ArrayList<Integer>> ans;    
	public String[][] solveNQueens(int A) {
       N = A;        
       ans = new ArrayList<ArrayList<Integer>>();
       nQueen(0,new ArrayList<Integer>());       
       String[][] ret = new String[ans.size()][N];    
       for(int i = 0 ; i < ans.size() ; i++)
       {
          ret[i] = board2D(ans.get(i),N); 
       }
       return ret;
	}

    public String[] board2D(ArrayList<Integer> arr,int N)
    {
        String[] board = new String[N];
        for(int i = 0 ; i < N ; i ++)
        {
            char[] temp = new char[N];
            int col = arr.get(i);
            for(int j = 0 ; j < N ; j++)
            {
                if(j == col)
                {
                    temp[j] ='Q';
                }
                else
                {
                    temp[j] ='.';
                }
            }
            String y = new String(temp);            
            board[i] = y;

        }
        return board;
    }

    public void nQueen(int r ,ArrayList<Integer> col)
    {
        // Base cases
        if(r == N)
        {
            ans.add((ArrayList)col.clone());
            return;
        }

        for(int c = 0 ; c < N ; c++)
        {
            if(isValid(r,c,col))
            {
                col.add(c);
                nQueen(r+1,col);
                col.remove(col.size()-1);
            }
        }
        return;
    }

    public boolean isValid(int r,int c,ArrayList<Integer> col)
    {
        for(int i = 0 ; i < col.size() ; i++)
        {
            if(isAttack(r,c,i,col.get(i)))
            {
                return false;
            }
        }
        return true;
    }


    public boolean isAttack(int r1,int c1,int r2,int c2)
    {
        return (r1 == r2) || (c1 == c2) || (r1 - c1 == r2 - c2) || (r1 + c1 == r2 + c2);
    }
	
}
