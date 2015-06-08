import java.util.*;

public class Solution216 {
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        recSum3(1, k, n, res, temp);
        return res;
    }
    public static void recSum3(int start, int k, int n, List<List<Integer>> res, List<Integer> temp)
    {
    	for(int i = start; i <= 9; i++)
        {
            if(k == 0 || n < 0)
                break;
            else if(k == 1 && n - i == 0)
            {
            	temp.add(i);
                res.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
                break;
            }
            else
            {
                temp.add(i);
                recSum3(i+1, k-1, n-i, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(3, 15));
		
	}

}
