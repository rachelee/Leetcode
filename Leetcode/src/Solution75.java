
public class Solution75 {
	//quick sort
	public void sortColors2(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        recSort(nums, 0, nums.length-1);
    }
    private void recSort(int[] nums, int a, int b)
    {
        if(b-a <= 0)
            return;
        int mid = (a+b)/2;
        int num = nums[mid];
        swap(nums, a, mid);
        int pivot = a;
        for(int i = a+1; i <= b; i++)
        {
            if(nums[i] < num)
            {
                swap(nums, i, ++pivot);
            }
        }
        swap(nums, a, pivot);
        recSort(nums, a, pivot);
        recSort(nums, pivot+1, b);
        
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //counting sort
    public void sortColors(int[] nums) {
        int a = 0;//number of 0s
        int b = 0;//number of 1s
        int c = 0;//number of 2s
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                a++;
            }
            else if(nums[i] == 1)
            {
                b++;
            }
            else if(nums[i] == 2)
            {
                c++;
            }
        }
        int i = 0;
        while(i<a)
        {
            nums[i] = 0;
            i++;
        }
        while(i<a+b)
        {
            nums[i] = 1;
            i++;
        }
        while(i<a+b+c)
        {
            nums[i] = 2;
            i++;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0};
		Solution75 test = new Solution75();
		test.sortColors(arr);
		System.out.println(arr);
		
	}

}
