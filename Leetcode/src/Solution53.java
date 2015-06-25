
public class Solution53 {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int maxNum = res[0];
        for(int i = 1; i < nums.length; i++)
        {
            res[i] = Math.max(nums[i], nums[i] + res[i-1]);
            maxNum = Math.max(res[i], maxNum);
        }
        
        return maxNum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
