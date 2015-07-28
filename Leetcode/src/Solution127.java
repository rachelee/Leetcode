import java.util.*;
import java.util.LinkedList;



public class Solution127 {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int queueLen = 1; // last queue length
        int curLen = 0; // current queue length
        int level = 1;
        while(!queue.isEmpty())
        {
                String word = queue.poll();
                queueLen--;
                    
                char[] wordArr = word.toCharArray();
                for(int i = 0; i < wordArr.length; i++)
                {
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                    	
                        if(wordArr[i]!=c)
                        {
                            char temp = wordArr[i];
                            wordArr[i] = c;
                            String newWord =new String(wordArr);
                            //System.out.println(newWord);
                            if(newWord.equals(endWord))
                            {
                                return level+1;
                            }
                            if(wordDict.contains(newWord))
                            {
                                queue.add(newWord);
                                curLen++;
                                wordDict.remove(newWord);
                            }
                            wordArr[i] = temp;
                        }
                        
                    }
                    
                }
                if(queueLen == 0)
                {
                    queueLen = curLen;
                    curLen = 0;
                    level++;
                }
        }
        return 0;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a  = "hot";
		String b = "dog";
		Set<String> arr = new HashSet<>();
		arr.add("hot");
		arr.add("dog");
		arr.add("dot");
		System.out.println(ladderLength(a, b, arr));
	}

}
