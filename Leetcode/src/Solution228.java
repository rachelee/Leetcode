import java.util.List;
import java.util.ArrayList;
public class Solution228 {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0)
            return res;
        int start = nums[0];
        int cur;
        int prev = nums[0];
        
        if(nums.length == 1)
            res.add(String.valueOf(start));
        for(int i = 1; i < nums.length; i++)
        {
            cur = nums[i];
            if(cur - 1 > prev)
            {
                if(start == prev)
                    res.add(String.valueOf(start));
                else
                    res.add(String.valueOf(start) + "->" + String.valueOf(prev));
                if(i < nums.length-1)
                {
                    start = cur;
                }
                else
                    res.add(String.valueOf(cur));
                prev = cur;
                continue;
            }
            if(i == nums.length-1)
                res.add(String.valueOf(start) + "->" + String.valueOf(cur));
            prev = cur;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,5,9};
		Solution228 test = new Solution228();
		System.out.println(test.summaryRanges(nums));
	}

}
