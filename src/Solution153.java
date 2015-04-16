
public class Solution153 {
	/*
	 * The naive solution is to interate through the list and 
	 * find the first num[i] < num[i-1] , time complexity O(n)
	 * 
	 * Using binary search here, time complexity O(logn)
	 */
	public int findMin(int[] num) {
        if(num.length == 0)
            return 0;
        int right = num.length-1, left = 0, mid;
        
        //no rotation
        if(num[right] > num[left])
                return num[0];
        while(true)
        {
            if(left == right)
                return num[left];
                
            mid = (left+right)/2;
            if(num[mid] < num[left])
                right = mid;
            else if(num[mid] > num[left])
                left = mid;
            else
                left++;
        }
    }
}
