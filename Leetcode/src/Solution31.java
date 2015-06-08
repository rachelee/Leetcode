
public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums == null||nums.length <= 1)
            return;
            
        //find the first nums[i] > nums[i-1]
        int i = nums.length-1;
        for(; i > 0; i--)
        {    
            if(nums[i] > nums[i-1])
               break;
            
        }
        
        //if nums[i] > nums[i-1] exists, find the smallest nums[j] that is 
        //bigger than nums[i-1]. Since the array should be in desending order from 
        //nums[i], I just need to find the first nums[j] that is bigger than
        //nums[i-1]
        if(i != 0)
        {
            int j = nums.length-1;
            for(; j > i-1; j--)
            {
                if(nums[j] > nums[i-1] )
                {
                    swap(i-1, j, nums);
                    break;
                }
            }
            
        }
        
        //reverse the array from nums[i] to nums[length-1]
        //to get the smallest set
        int start = i;
        int end = nums.length-1;
        while(start < end)
        {
            swap(start, end, nums);
            start++;
            end--;
        }
            
       
        
    }
    
    private void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
