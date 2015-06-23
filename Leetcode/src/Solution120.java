import java.util.*;
public class Solution120 {
	public static int minimumTotal2(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<>();
        res.add(triangle.get(0).get(0));
        int temp = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++)
        {
            List<Integer> row = triangle.get(i);
            int min;
            for(int j = 0; j < row.size(); j++)
            {
                if(j == 0)
                {
                    min = res.get(j) + row.get(j);
                    res.set(j, min);
                }
                else if(j+1 == row.size())
                {
                    min = temp + row.get(j);
                    res.add(j, min);
                    temp = res.get(0);
                }
                else
                {
                	
                    min = Math.min(temp + row.get(j), res.get(j) + row.get(j));
                    temp = res.get(j);
                    res.set(j, min);
                    
                }
                
            }
        }
        
        int minPath = Integer.MAX_VALUE;
        for(Integer i: res)
        {
            minPath = Math.min(minPath, i);
        }
        return minPath;
    } 
	//O(n2) space
	public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(triangle.get(0).get(0));
        res.add(first);
        for(int i = 1; i < triangle.size(); i++)
        {
            List<Integer> row = triangle.get(i);
            List<Integer> temp = new ArrayList<Integer>();
            int min;
            for(int j = 0; j < row.size(); j++)
            {
                if(j-1 < 0)
                {
                    min = res.get(i-1).get(j) + row.get(j);
                }
                else if(j+1 == row.size())
                {
                    min = res.get(i-1).get(j-1) + row.get(j);
                }
                else
                {
                    min = Math.min(res.get(i-1).get(j-1) + row.get(j), res.get(i-1).get(j) + row.get(j));
                }
                temp.add(min);
            }
            res.add(temp);
        }
        
        int minPath = Integer.MAX_VALUE;
        for(Integer i: res.get(res.size()-1))
        {
            minPath = Math.min(minPath, i);
        }
        return minPath;
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		list.add(temp);
		temp = new ArrayList<>();
		temp.add(2);
		temp.add(3);
		list.add(temp);
		System.out.println(minimumTotal2(list));
	}

}
