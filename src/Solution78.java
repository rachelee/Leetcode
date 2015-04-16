
import java.util.*;
public class Solution78 {
	
	/*这道题是要求生成所有子集，那么首先我们有一个能返回所有子集的ArrayList res, 和一个临时变量ArrayList tmp, 当tmp满足一定条件的时候，往res里面添加结果

	Subset这道题的条件比较直观，就是每当我们添加了一个元素，都是一个新的子集。那么我们怎么保证不会出现重复集合呢。我们引入一个int pos用来记录此子集的起点在哪，比如当pos = 1的时候就是从第二个元素往后循环添加元素（0 base）,每次当此层用了第i个元素，那么下一层需要传入下一个元素的位置i+1 除此之外，当循环结束要返回上一层dfs的时候我们需要把这一层刚添加元素删去。

	比如输入集合为［1，2，3］应当是这么运行，

	[]

	[1]

	[1,2]

	[1,2,3] //最底层子循环到头返回删去3，上一层的子循环也到头删去2

	          //而此时，这一层循环刚到2，删去后还可以添加一个3

	[1,3] //删除3，删除1

	[2]

	[2,3] //删除3，删除2

	[3]*/
	public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        res.add(temp);
        dfs(0, S, res, temp);
        return res;
    }
    
    public void dfs(int start, int[] S, List<List<Integer>> res, List<Integer> temp)
    {
        for(int i = start; i < S.length; i++)
        {
            temp.add(S[i]);
            res.add(new ArrayList<Integer>(temp));
            dfs(i+1, S, res, temp);
            temp.remove(temp.size()-1);
        }
        
    }
    
    /*
     * 1. sort the array
     * 2. add the empty list to res
     * 3. call insert() to add the ith element to all the List in res
     *     then add the new Lists to the res
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
