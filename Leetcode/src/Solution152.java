
public class Solution152 {
	public static int maxProduct(int[] nums) {
        int max = nums[0];
        int maxLocal = nums[0];
        int minLocal = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(temp*nums[i], nums[i]), minLocal*nums[i]);
            minLocal = Math.min(Math.min(temp*nums[i], nums[i]), minLocal*nums[i]);
            max = Math.max(maxLocal, max);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,0,-2,6};
		System.out.println(maxProduct(arr));
	}

}
