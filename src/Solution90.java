

import java.util.*;

public class Solution90 {
	
	/*
	 * 我们需要做的是，在删去元素后，再取元素的时候，不要取和刚刚取过的元素相等的元素 即加上这么一条语句
	 */
	public List<List<Integer>> subsetsWithDup(int[] num) {
        if(num == null)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        
        Arrays.sort(num);
        dfs(0, num, temp, res);

        return res;
    }
    
    public void dfs(int start, int[] num, List<Integer> temp, List<List<Integer>> res)
    {
        for(int i = start; i < num.length; i++)
        {
            temp.add(num[i]);
            res.add(new ArrayList<Integer>(temp));
            dfs(i+1, num, temp, res);
            temp.remove(temp.size()-1);
            while(i<num.length-1 && num[i]==num[i+1])
                i++;
        }
    }
	/*
	 * Use a HashSet to eliminate the duplicates
	 */
	public List<List<Integer>> subsets2(int[] S) {
        if(S == null)
            return null;
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        
        for(int i = 0; i < S.length; i++)
        {
            insert(S[i], res);
        }
        return res;
    }
    
    public void insert(int elem, List<List<Integer>> res)
    {
        List<List<Integer>> tempRes = new ArrayList<List<Integer>>();
        for(List<Integer> cur:res)
        {
            List<Integer> temp = new ArrayList<Integer>(cur);
            temp.add(elem);
            tempRes.add(temp);
        }
        
        res.addAll(tempRes);
    }
}
