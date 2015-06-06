
public class Solution33 {
	public static int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        while(first <= last)
        {
            int mid = (first+last)/2;
            if(target == nums[mid])
                return mid;
            else if(nums[first] <= nums[mid])
            {
                if(target >= nums[first] && target <=nums[mid])
                    last = mid-1;
                else
                    first = mid+1;
            }
            else
            {
                if(target <= nums[last] && target >= nums[mid])
                    first = mid+1;
                else
                    last = mid-1;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArray = {3,1};
		int target = 1;
		int result = search(myArray, target);
		System.out.println(result);
	}

}
