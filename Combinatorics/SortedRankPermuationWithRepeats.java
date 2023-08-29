// Given a string A, find the rank of the string amongst its permutations sorted lexicographically.

// Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations.

// Look at the example for more details.

// NOTE:

// The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
// String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.
public class Solution {
    
  
    public  int[] freq = new int[52];
    
    public int len;    
    public int findRank(String A) {
        int mod = 1000003;
        len = A.length();        
        buildFrequencyMap(A);
        long ans = 0L;
        for(int i = 0 ; i < len ; i++)
        {
            long nr = 0L;
            long dr = 1L;
            long contribution = 0L;
            int curAscii = getMyASCII(A.charAt(i));
            for(int j = 0 ; j < curAscii ; j++)
            {
                if(freq[j]!=0)
                {
                    freq[j]-- ; //Swapped
                    long noOfPlaceAvailable = len - (i+1);
                    nr = fact(noOfPlaceAvailable,Long.valueOf(mod));
                    for(int k = 0 ; k < 52 ;k++)
                    {
                        if(freq[k]>1)
                        {
                            dr = (dr * fact(Long.valueOf(freq[k]),Long.valueOf(mod)))%mod;
                        }
                    }
                    contribution = (nr * fastPower(dr,Long.valueOf(mod-2),Long.valueOf(mod))) % mod;
                    ans = (ans + contribution)%mod;
                    freq[j]++;                    
                    dr = 1L;

                }
            }
            freq[curAscii]--;
        }
        return (int)(ans+1);

    }

    public void buildFrequencyMap(String A)
    {
        for(int i = 0 ; i < len ; i++)
        {
            freq[getMyASCII(A.charAt(i))]++;
        }
    }

    public int getMyASCII(char x)
    {
        int ascii = (int)x;
        if(ascii <= 90) // Capital Letter
        {
            return ascii - 65;
        }
        else
        {
            return ascii - 97 + 26;
        }
    }

    public int fastPower(long a,long b,long m)
    {
        long ans = 1L;

        while(b > 0)
        {
            if(b % 2 == 0) //Even
            {
                a = (a*a)%m;
                b =b/2;                
            }
            else
            {                
                
                ans = (ans * a) % m;               
                a = (a*a)%m;
                b =b/2;  
                
            }
        }
        return (int)(ans%m);
    }

    public long fact(long N,long P)
    {
        long ans = 1;
        for(long i =1;i<=N;i++)
        {
            ans = (ans * i) % P;
        }
        return ans;
    }


    
}
