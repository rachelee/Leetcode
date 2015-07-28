
public class Solution45 {
	public static int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int jump = 0;
        int reach = nums.length-1;
        int tempReach = nums.length-1;

        for(int i = 1; i < nums.length; i++)
        {
        
        	if(i+nums[nums.length-1-i] >= reach)
        	{
        		tempReach = nums.length-1-i;
        		if(i == nums.length-1)
        			jump+=1;
        	}
            else
            {
                reach = tempReach;
                jump +=1;
            }
        }
        if(nums[0] >= tempReach)
            return jump+1;
        else 
            return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(jump(nums));
	}

}
