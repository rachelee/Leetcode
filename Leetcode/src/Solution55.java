
public class Solution55 {
	//two pointers, one is the max index can be reached
		//one is the current index
	    public boolean canJump1(int[] nums) {
	        if(nums.length <=1)
	            return true;
	        int i = 0;
	        int j = 0;
	        for(;i<nums.length; i++)
	        {
	            if(i==j&&nums[i]==0)
	            {
	                if(i==nums.length-1)
	                    return true;
	                return false;
	            }
	            if(i>j)
	                return false;
	            j = Math.max(i+nums[i], j);
	            
	        }
	        return true;
	    }
	    public static boolean canJump(int[] nums) {
	        if(nums.length <= 1)
	            return true;
	        int reach = 0;
	        for(int i = 0; i < nums.length; i++)
	        {
	        	if(i>reach)
	        		return false;
	            reach = Math.max(reach, i+nums[i]);
	            if(reach >= nums.length-1)
	                return true;
	        }
	        return false;
	        
	       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
