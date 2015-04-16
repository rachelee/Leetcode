
import java.util.*;
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length; i++)
        {
            HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
            for(int j = i+1; j<num.length; j++)
            {
                if(table.containsKey(num[j]))
                {
                    int jValue = table.get(num[j]);
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(num[i]);
                    newList.add(jValue);
                    newList.add(num[j]);
                    res.add(newList);
                    break;
                }
                else
                {
                    int newNum = -(num[i]+num[j]);
                    table.put(newNum, num[j]);
                }
               
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1, 0, 1};
		List<List<Integer>> res = threeSum(a);
		System.out.println(res);
	}

}
