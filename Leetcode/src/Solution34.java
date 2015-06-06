

public class Solution34 {
	public int[] searchRange(int[] A, int target) {
        int start = 0, end = A.length-1;
        int mid;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(true)
        {
            mid = (start + end)/2;
            if(A[mid] == target)
                break;
            if(A[mid] < target)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
            
            if(start > end)
                return res;
        }
        
        start = mid; 
        end = mid;
        while(true)
        {
            if(start < 0 || A[start] != target)
            {
                res[0] = start+1;
                break;
            }
            else 
            {
                start--;
            }
            
        }
        
        while(true)
        {
            if(end >=A.length || A[end] != target)
            {
                res[1] = end-1;
                break;
            }
            else 
            {
                end++;
            }
            
        }
        
        return res;
    }
}
