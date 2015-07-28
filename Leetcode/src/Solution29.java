
public class Solution29 {
	public int divide(int dividend, int divisor) {
		int flag = 1;
		if(divisor < 0)
		{
			divisor = -divisor;
			flag = -1;
		}
        while(true)
        {
            if(divisor == 1)
            {
            	if(flag == 1)
            		return dividend;
            	else
            		return -dividend;
            }
            if(divisor%2 != 0 && divisor/2 == 1)
            {
                divisor = divisor%2*10;
                dividend = dividend/2*10;
            }
            divisor = divisor/2;
            dividend = dividend/2;
            
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution29 test = new Solution29();
		System.out.println(test.divide(10, 3));
	}

}
