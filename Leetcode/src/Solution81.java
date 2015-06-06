
public class Solution81 {
	public static boolean search(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        while(first <= last)
        {
            int mid = (first+last)/2;
            if(target == nums[mid])
                return true;
            else if(nums[first] < nums[mid])
            {
                if(target >= nums[first] && target < nums[mid])
                    last = mid-1;
                else
                    first = mid+1;
            }
            else if(nums[first] > nums[mid])
            {
                if(target <= nums[last] && target > nums[mid])
                    first = mid + 1;
                else
                    last = mid - 1;
            }
            else
            		first++;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,1,1,1};
		boolean contains = search(nums, 3);
		System.out.println(contains);
	}

}
