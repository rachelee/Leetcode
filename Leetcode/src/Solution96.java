
public class Solution96 {
	//Recursive
	public int numTrees2(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        int sum = 0;
        for(int i = 0; i<n;i++){
             sum+=numTrees(i)*numTrees(n-1-i);
        }
        return sum;
    }
	
	//Dynamic programming
	public int numTrees(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1; 
        int[] numbers = new int[n+1];
        numbers[0] = 1;
        numbers[1] = 1;
        for(int i = 2; i<numbers.length;i++){
            for(int j=0;j<i;j++){
                numbers[i]+=numbers[j]*numbers[i-1-j];
            }
        }
        return numbers[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution96 test = new Solution96();
		System.out.println(test.numTrees(3));
	}

}
