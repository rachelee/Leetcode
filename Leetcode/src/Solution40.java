import java.util.*;
public class Solution40 {
	//if the array is not sorted, use continue 
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        recSum(0, target, candidates, res, temp);
        
        return res;
    }
    private static void recSum(int start, int target, int[] candidates, List<List<Integer>> tempRes, List<Integer> temp)
    {
        for(int i = start; i < candidates.length; i++)
        {
            if(target-candidates[i] < 0)
                continue;
                
            temp.add(candidates[i]);
            if(target-candidates[i] == 0)
            {
                tempRes.add(new ArrayList<Integer>(temp));
            }
            else
                recSum(i+1, target-candidates[i], candidates, tempRes, temp);
            temp.remove(temp.size()-1);
            
        }
    }
    
    //if the array is sorted, use break. since the element after i will be even bigger than array[i]
    //so no point to continue
    public static List<List<Integer>> combinationSumCorrect(int[] candidates, int target) {
        //Arrays.sort(candidates);
    		List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        recSumCorrect(0, target, candidates, res, temp);
        
        return res;
    }
    private static void recSumCorrect(int start, int target, int[] candidates, List<List<Integer>> tempRes, List<Integer> temp)
    {
        for(int i = start; i < candidates.length; i++)
        {
            if(target-candidates[i] < 0)
                break;
                
            temp.add(candidates[i]);
            if(target-candidates[i] == 0)
            {
                tempRes.add(new ArrayList<Integer>(temp));
            }
            else
                recSum(i+1, target-candidates[i], candidates, tempRes, temp);
            temp.remove(temp.size()-1);
            
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {8,7,4,3};
		List<List<Integer>> res = combinationSum2(candidates, 11);
		System.out.println(res);
	}

}
