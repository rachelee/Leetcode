import java.util.*;
public class Solution140 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] arr = new ArrayList[s.length()+1];
        arr[0] = new ArrayList<String>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==null)
                continue;
            for(String str:wordDict){
                int end = i+str.length();
                if(end>s.length())
                    continue;
                if(s.substring(i, end).equals(str)){
                    if(arr[end] == null)
                        arr[end] = new ArrayList<String>();
                    arr[end].add(str);
                }
            }
        }
        printArray(arr);
        List<String> res = new ArrayList<String>();
        String a = new String();
        recAdd(arr, arr.length-1, a, res);
        return res;
        
    }
	private void printArray(List<String>[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
    private void recAdd(List<String>[] arr, int end, String a, List<String> res){
        if(end < 0)
            return;
        if(end == 0){
            res.add(a.substring(0, a.length()-1));
            return;
        }
        List<String> words = arr[end];
        if(words != null)
	        for(int i = 0; i<words.size(); i++){
	            String word = words.get(i);
	            String b = word+" "+a;
	            recAdd(arr, end-word.length(), b, res);
	        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		String[] arr = {"cat","cats","and","sand","dog"};
		Set<String> wordDict = new HashSet<String>(Arrays.asList(arr));
		//System.out.println(wordDict);
		Solution140 test = new Solution140();
		System.out.println(test.wordBreak(s, wordDict));
	}

}
