
public class Solution50 {
	//Naive solution
	public static double pow(double x, int n) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        double res = 1;
        for(int i = 0; i < n; i++)
        {
            res = res * x;
        }
        
        return res;
    }
	
	//Accepted solution
	public static double pow2(double x, int n) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        
        if(n < 0)
        {
            x = 1/x;
            n = -n;
        }
        double v = pow(x, n/2);
        if(n%2 == 0)
            return v*v;
        else
            return v*v*x;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow2(34.00515, 1));
	}

}
