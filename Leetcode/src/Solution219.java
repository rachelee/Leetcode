import java.util.*;
public class Solution219 {
	//two pointer
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0 || nums.length == 0)
            return false;
        int i = 0;
        int j = 1;
        while(j<nums.length)
        {
            if(j-i<=k)
            {
                if(nums[i] == nums[j])
                    return true;
                else
                    j++;
            }
            else
                i++;
        }
        return false;
    }
	
	//Hashmap
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if(map.containsKey(num))
            {
                if(i - map.get(num) <= k)
                    return true;
            }
            map.put(num, i);
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
