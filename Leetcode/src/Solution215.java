
public class Solution215 {
	public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1)
            return nums[0];
        int s = nums.length-k;
        return recFind(nums, s, 0, nums.length-1);
    }
    private int recFind(int[] nums, int k, int l, int r){
        if(l <= r)
        {
            int mid = (l+r)/2;
            swap(nums, l, mid);
            int target = nums[l];
            int pivot = l;
            for(int i = l+1; i <= r; i++)
            {
                int num = nums[i];
                if(num < target)
                {
                	pivot++;
                    swap(nums, i, pivot);
                }
            }
            swap(nums, l, pivot);
            if(pivot == k)
                return nums[pivot];
            else if(pivot > k)
                return recFind(nums, k, l, pivot-1);
            else
                return recFind(nums, k, pivot+1, r);
            
        }
        else
            return -1;
        
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution215 test  = new Solution215();
		int[] arr = {99,99};
		System.out.println(test.findKthLargest(arr, 1));
	}

}
