
public class Solution231 {
	public boolean isPowerOfTwo(int n) {
        if(n < 0)
            return false;
        int count = 0;
        for(int i = 0; i < 32; i++)
        {
            if(getBit(n, i))
                count++;
        }
        if(count == 1)
            return true;
        else
            return false;
    }
    private boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution231 test = new Solution231();
		System.out.println(test.isPowerOfTwo(1));
	}

}
