

public class ClimbStairs {

	public static int climbStairs(int n) {
        int[] cache = new int[n];
        for(int i = 0; i < n; i++)
            cache[i] = -1;
        return countWays(n, cache);
    }
    static int countWays(int n, int[] cache){
        if(n < 0)
            return 0;
        else if(n == 0)
            return 1;
        else if(cache[n-1] > -1 )
            return cache[n-1];
        else
        {
            cache[n-1] = countWays(n-1, cache)+countWays(n-2, cache);
            return cache[n-1];
        }
        
    }
	public static void main(String[] args) {
		System.out.println(climbStairs(20));
	}

}
