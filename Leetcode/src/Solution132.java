import java.util.*;
public class Solution132 {
	public int minCut(String s) {
        List<Integer> cuts = new ArrayList<Integer>();
        dfs(s, 0, 0, cuts);
        int min = Integer.MAX_VALUE;
        for(Integer i:cuts){
            min = Math.min(i, min);
        }
        return min;
    }
    private void dfs(String s, int start, int cut, List<Integer> cuts){
        if(start == s.length())
        {
            cuts.add(cut-1);
            return;
        }
        for(int i = start+1;i<=s.length();i++){
            String a = s.substring(start, i);
            if(isPalindrome(a)){
                dfs(s, i, cut+1, cuts);
            }
            
        }
    }
    private boolean isPalindrome(String s){
        int i = 0; 
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		Solution132 test= new Solution132();
		System.out.println(test.minCut(s));
	}

}
