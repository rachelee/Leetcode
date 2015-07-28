import java.util.*;
public class Solution229 {
	public List<Integer> majorityElement(int[] nums) {
        int candi1 = 0;
        int candi2 = 1;
        int count1 = 0;
        int count2 = 0;
        for(int a: nums)
        {
            if(a == candi1)
                count1++;
            else if(a == candi2)
                count2++;
            else if(count1 == 0)
            {
                candi1 = a;
                count1 = 1;
            }
            else if(count2 == 0)
            {
                candi2 = a;
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
            
        }
        
        count1 = 0; 
        count2 = 0;
        for(int a: nums)
        {
            if(a == candi1)
                count1++;
            else if(a == candi2)
                count2++;
        }
        
        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length/3)
            res.add(candi1);
        if(count2 > nums.length/3)
            res.add(candi2);
            
        return res;
	}
}
