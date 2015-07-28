import java.util.Arrays;
public class Solution238 {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length+1];
        res[0] = 1;
        for(int i = 0; i < res.length-1; i++)
        {
            res[i+1] = res[i]*nums[i];
        }
        int temp = 1;
        for(int i = nums.length-1; i >=0; i--)
        {
            res[i] *= temp;
            temp *= nums[i];
        }
        
        return Arrays.copyOf(res, nums.length);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0};
		Solution238 test = new Solution238();
		int[] res = test.productExceptSelf(arr);
		for(int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}

}
