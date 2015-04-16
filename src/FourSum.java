

import java.util.*;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num.length < 4)
            return res;
        
        Arrays.sort(num);
        for(int i = 0; i < num.length-3; i++)
        {
            if(i == 0||num[i] > num[i-1])
            {
                for(int j = i+1; j < num.length-2; j++)
                {
                    if(j == i+1||num[j] > num[j-1])
                    {
                        int start = j+1;
                        int end = num.length-1;
                        int parSum = target - num[i] - num[j];
                        while(start<end)
                        {
                            List<Integer> newList = new ArrayList<Integer>();
                            if(num[start] + num[end] == parSum)
                            {
                                newList.add(num[i]);
                                newList.add(num[j]);
                                newList.add(num[start]);
                                newList.add(num[end]);
                                res.add(newList);
                                start++;
                                end--;
                                while(start<end&&num[start] == num[start-1])
                                    start++;
                                while(start<end&&num[end] == num[end+1])
                                    end--;
                            }
                            else if(num[start] + num[end] > parSum)
                                end--;
                            else
                                start++;
                        }
                    }
                }
            }
        }
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,0,0};
		List<List<Integer>> test = fourSum(a, 0);
		System.out.println(test);
		
	}

}
