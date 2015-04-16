
public class Solution69 {
	public static int sqrt(int x) {
        if(x == 0)
            return 0;
        if(x < 0)
            return -1;
            
        int l = 1;
        int r = x/2+1;
        
        while(l <= r)
        {
            int m = (l+r)/2;
            
            if(m <= x/m && m+1 > x/(m+1))
                return m;
            if(m < x/m)
                l = m+1;
            if(m > x/m)
                r = m-1;
            
        }
        
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(1));
	}

}
