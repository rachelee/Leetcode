import java.util.*;
public class Solution49 {
	public List<String> anagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++)
        {
            Map<Character, Integer> wordMap = new HashMap<>();
        
            String word = strs[i];
            for(int j = 0; j < word.length(); j++)
            {
                char c = word.charAt(j);
                if(wordMap.containsKey(c))
                {
                    wordMap.put(c, wordMap.get(c)+1);
                }
                else
                    wordMap.put(c, 1);
            }
            if(map.containsKey(wordMap))
            {
                map.get(wordMap).add(word);
            }
            else
            {
                List<String> anagrams = new ArrayList<String>();
                anagrams.add(word);
                map.put(wordMap, anagrams);
            }
            
        }
        List<String> res = new ArrayList<String>();
        for(List<String> l:map.values())
        {
            if(l.size()>1)
                res.addAll(l);   
        }
        
        return res;
        
    }
	
	public List<String> anagrams2(String[] strs) {
	    ArrayList<String> result = new ArrayList<String>();
	    if(strs == null || strs.length == 0)
	        return result;
	 
	    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	    for(int i=0; i<strs.length; i++){
	        char[] arr = strs[i].toCharArray();
	        Arrays.sort(arr);
	        String t = String.valueOf(arr);
	        if(map.get(t) == null){
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(i);
	            map.put(t, l);
	        }else{
	            map.get(t).add(i);
	        }
	    }
	 
	    for(ArrayList<Integer> l: map.values()){
	        if(l.size() > 1){
	            for(Integer i: l){
	                result.add(strs[i]);
	            }
	        }
	    }
	 
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
