import java.util.*;
public class Solution126 {
//	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        Queue<List<String>> cur = new LinkedList<List<String>>();
//        Queue<List<String>> next = new LinkedList<List<String>>();
//        List<String> temp = new ArrayList<>();
//        temp.add(start);
//        if(dict.contains(start))
//        	dict.remove(start);
//        cur.add(new ArrayList<String>(temp));
//        int countAdd = 0;
//        List<List<String>> res = new ArrayList<>();
//        while(!cur.isEmpty()){
//            
//             temp = cur.poll();
//             System.out.println("1. " + temp);
//             String word = temp.get(temp.size()-1);
//             char[] wordArr = word.toCharArray();
//             for(int j = 0; j < wordArr.length; j++)
//             {
//                 for(char c = 'a'; c <= 'z'; c++)
//                 {
//                	 if(c != wordArr[j])
//                	 {
//                		 char tmp = wordArr[j];
//                         wordArr[j] = c;
//                         String newWord = new String(wordArr);
//                         if(newWord.equals(end)){
//                             temp.add(end);
//                             res.add(new ArrayList<String>(temp));
//                             System.out.println("2. "+res);
//                             temp.remove(end);
//                         }
//                         else if(dict.contains(newWord))
//                         {
//                             countAdd++;
//                             temp.add(newWord);
//                             next.add(new ArrayList<String>(temp));
//                             System.out.println("3. "+next);
//                             dict.remove(newWord);
//                             temp.remove(newWord);
//                         }
//                         wordArr[j] = tmp;
//                	 }
//                 }
//             }
//             if(cur.isEmpty())
//             {
//                 
//                 if(!res.isEmpty())
//                    return res;
//                if(countAdd == 0)
//                {
//                    return res;
//                }
//                 cur = next;
//                 next = new LinkedList<List<String>>();
//                 countAdd = 0;
//             }
//             
//        }
//        return res;
//        
//    }
	
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<>();
        temp.add(start);
        int shortCount = dict.size()+2;
        if(dict.contains(start))
        	dict.remove(start);
        res.add(new ArrayList<String>(temp));
        //int countAdd = 0;
        for(String w: dict)
        {
            List<List<String>> tempRes = new ArrayList<List<String>>();
            for (List<String>tmp: res){
                String word = tmp.get(tmp.size()-1);
                if(word.equals(end))
                {
                    continue;
                }
        	    if(changed(word, w))
        	    {
        	      
                    tmp.add(w);
                    tempRes.add(new LinkedList<String>(tmp));
                    if(w.equals(end))
        	            shortCount = Math.min(tmp.size(), shortCount);
                    tmp.remove(w);
                    
                }
                 
            }
            res.addAll(tempRes);
        
        
        }
        List<List<String>> ret = new ArrayList<>();
        for(List<String> l:res)
        {
            if(l.size() == shortCount && l.get(l.size()-1).equals(end))
                ret.add(l);
        }
        return ret;
    }
    private static boolean changed(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        if(count == 1)
            return true;
        return false;
    }
    private static boolean change(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        if(count == 1)
            return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String start = "red";
//		String end = "tax";
//		Set<String> dict = new HashSet<>();
//		dict.add("ted");
//		dict.add("tex");
//		dict.add("red");
//		dict.add("tax");
//		dict.add("tad");
//		dict.add("den");
//		dict.add("rex");
//		dict.add("pee");
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		
		List<List<String>> res = findLadders(start, end, dict);
		System.out.println(res);
	}

}
