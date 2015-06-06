import java.util.*;
public class Solution39 {
	
        
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        recSum(0, candidates, target, res, temp);
        return res;
    }
    private static void recSum(int start, int[] candidates, int target, List<List<Integer>> setResult, List<Integer> temp)
    {
        for(int i = start; i<candidates.length;i++)
        {
            if(target - candidates[i] < 0)
                break;
               
            temp.add(candidates[i]); 
            if(target - candidates[i]  == 0)
            {
                setResult.add(new ArrayList(temp));
            }
            else
            {
                recSum(i, candidates, target-candidates[i], setResult, temp);
            }
            temp.remove(temp.size()-1);
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
