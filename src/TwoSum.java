

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int a:numbers)
        {
            table.put(a, target-a);
        }
        
        for(int a:numbers)
        {
            int num = table.get(a);
            Integer value = table.get(num); 
            if(value != null)
            {
                res[0] = a;
                res[1] = num;
                break;
            }
        }
        
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] == res[0])
                res[0] = i;
        }
        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] == res[0])
                res[1] = i;
        }
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,4};
		int[] res = twoSum(array, 6);
		System.out.println(Arrays.toString(res));

	}

}
