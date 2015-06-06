

public class PalindromaNumber {
	public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        
        int div = 10;
        while(x/div >= 10)
        {
            div*=10;
        }
        
        while(x>0)
        {
            if(x/div != x%10)
                return false;
            x = x % div /10;
            div = div/100;
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1001));
	}

}
