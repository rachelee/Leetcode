import java.util.*;
public class Solution139 {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null||s.length()==0)
            return true;
        boolean[] arr = new boolean[s.length()+1];
        int start = 0;
        int end = 0;
        arr[0] = true;
        for(start = 0; start < arr.length; start++){
            if(!arr[start])
                continue;
            for(String str:wordDict){
                    end = start+str.length();
                    if(end > s.length())
                        continue;
                    if(arr[end] == true)
                        continue;
                    if(s.substring(start, end).equals(str))
                        arr[end] = true;
            }
        }
        return arr[arr.length-1];
        
    }
        
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution139 test = new Solution139();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("a");
		System.out.println(test.wordBreak("a", wordDict));
	}

}
