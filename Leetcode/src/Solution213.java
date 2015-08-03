
public class Solution213 {
	public int rob(int[] nums) {
        if(nums.length <= 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] res1 = new int[nums.length+1];//first is included and last is excluded
        int[] res2 = new int[nums.length+1];//first is excluded and last is included
        res1[0] = 0;
        res1[1] = nums[0];
        res2[0] = 0;
        res2[1] = nums[1];
        for(int i=2; i<nums.length; i++){
            res1[i] = Math.max(res1[i-2]+nums[i-1], res1[i-1]);
            res2[i] = Math.max(res2[i-2]+nums[i], res2[i-1]);
        }
        return res1[nums.length-1] >= res2[nums.length-1]?res1[nums.length-1]:res2[nums.length-1];
    }
}
