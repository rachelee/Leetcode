
public class Solution45 {
	public static int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int jump = 0;
        int current = 0;
        int tempCur = 0;
        for(int i = 0; i < nums.length; i++)
        {
        	if(current >= nums.length-1)
        		return jump;
        	tempCur = Math.max(tempCur, i+nums[i]);
            if(i>=current)
            {
                jump++;
                current = tempCur;
            }
            
            
        }
        return jump;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(jump(nums));
	}

}
