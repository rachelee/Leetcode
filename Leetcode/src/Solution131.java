import java.util.*;
public class Solution131 {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, 0, temp, res);
        return res;
    }
    private void dfs(String s, int start, List<String> temp, List<List<String>> res){
        if(start > s.length())
            return;
        if(start == s.length())
        {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=start+1; i<=s.length();i++){
            String a = s.substring(start, i);
            if(isPalindrome(a))
            {
                temp.add(a);
                dfs(s, i, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbbbcc";
		Solution131 test = new Solution131();
		System.out.println(test.partition(s));
	}

}
