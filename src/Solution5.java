
public class Solution5 {
	
	//1. Naive solution
	public static String longestPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        int max = 0;
        String str = new String();
        while(start <= end-max)
        {
        	boolean found = false;
            for(int strEnd = end; strEnd>=start; strEnd--)
            {
                int tempMax = strEnd - start + 1;
                String tempStr = s.substring(start, end+1);
                int i = start, j = strEnd;
                while(i < j)
                {
                    if(s.charAt(i) != s.charAt(j))
                        break;
                    else if((i == j || i == j-1) && (s.charAt(i) == s.charAt(j)))
                    {
                        if(tempMax > max)
                        {
                            str = tempStr;
                            max = tempMax;
                        }
                        found = true;
                        i++;
                        j--;
                    }
                    else
                    {
                        i++;
                        j--;
                    }
                }
                if(found == true)
                	break;
                
            }
            start++;
        }
        return str;
    }
	
	//dp solution Time O(n^2)  Space O(n^2)
	public String longestPalindromeDp(String s) {
		if(s == null)
            return s;
        int len = s.length();
        String ret = null;
        int max = 0;
        boolean[][] dp = new boolean[len][len]; //all value in boolean default to false
        for(int j = 0; j < len; j++)
        {
            for(int i = 0; i <= j; i++)
            {
                if(s.charAt(i) == s.charAt(j) && ((j-i <=2)||dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if(j-i+1 > max)
                    {
                        max = j-i+1;
                        ret = s.substring(i, j+1);
                    }
                }
            }
        }
        return ret;
    }
	
	//Method to expand from the middle. Time O(n^2)  Space O(1)
	public String longestPalindromeExpand(String s) {
        if(s == null)
            return null;
        
        int max = 0;
        String ret = null;
        for(int i = 0; i < s.length(); i++)
        {
            String sub;
            //odd number palindrome
           
            sub = getPString(s, i, i);
            if(sub.length() > max)
            {
                ret = sub;
                max = sub.length();
            }
            

            //even number palindrome
            sub = getPString(s, i, i+1);
            if(sub.length() > max)
            {
                ret = sub;
                max = sub.length();
            }
            
        }
        return ret;
    }
    
    private String getPString(String s, int left, int right)
    {
        while(left >= 0 && right <s.length())
        {
            if(s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        
        return s.substring(left+1, right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaa";
		System.out.println(longestPalindrome(str));
	}

}
