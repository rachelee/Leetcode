
import java.util.Arrays;
public class ArrayRotation {
	public void rotate(int[] nums, int k) {
        if(nums.length == 0)
            return;
        int len = nums.length;
        int gsd = gSD(len, k);
        int temp, cur, last;
        for(int i = 0; i <gsd; i++)
        {
            cur = i;
            temp = nums[cur];
            while(true)
            {
                last = cur - k;
                while(last < 0)
                {
                    last = last+len;
                }
                if(last == i)
                    break;
                nums[cur] = nums[last];
                cur = last;
                
            }
            nums[cur] = temp;
        }
    }
    
    int gSD(int n, int k){
        if(k == 0)
            return n;
        while(true)
        {
            int res = n%k;
            n = k;
            k = res;
            
            if(k == 0)
                return n;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2};
		ArrayRotation myClass = new ArrayRotation();
		myClass.rotate(a, 1);
		System.out.println(Arrays.toString(a));
	}

}
