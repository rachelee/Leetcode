
public class Solution209 {
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int i = 0;
        int j = 0;
        int min = nums.length + 1;
        while(j <= nums.length)
        {
            if(s <= 0)
            {
                if(j-i < min)
                    min = j-i;
                s = s + nums[i++];
            }
            else
            {
            	if(j == nums.length)
            		break;
                s = s - nums[j++];
            }
        }
        
        if(min == nums.length + 1)
            return 0;
            
        return min;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		System.out.println(minSubArrayLen(11, arr));
	}

}
