import java.util.*;
public class Solution3 {
	//Naive solution
	public static int lengthOfLongestSubstringNaive(String s) {
        int max = 1;
        for(int i = 0; i < s.length(); i++)
        {
            int length = 0;
            HashSet<Character> hs = new HashSet<Character>();
            for(int j = i; j < s.length(); j++)
            {
                if(hs.contains(s.charAt(j)))
                    break;
                else
                {
                    hs.add(s.charAt(j));
                    length++;
                }
                    
            }
            
            if(length > max)
                max = length;
        }
        
        return max;
    }
	
	//Accepted solution
	public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        HashSet<Character> hs = new HashSet<Character>();
        int length = 0;
        
        for(int i=0; i < s.length(); i++)
        {
            if(hs.contains(s.charAt(i)))
            {
                while(start < i && s.charAt(start) != s.charAt(i))
                {
                    hs.remove(s.charAt(start));
                    start++;
                    length--;
                }
                start++;
            }
            else
            {
                hs.add(s.charAt(i));
                length++;
            }
            
            max = Math.max(max, length);
        }
        
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
