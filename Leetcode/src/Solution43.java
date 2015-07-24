
public class Solution43 {
	public String multiply(String num1, String num2) {
		String rNum1 = new StringBuilder(num1).reverse().toString();
        String rNum2 = new StringBuilder(num2).reverse().toString();
        int[] arr = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++)
        {
            int n1 = Integer.valueOf(rNum1.substring(i, i+1));
            for(int j = 0; j < num2.length(); j++)
            {
                int n2 = Integer.valueOf(rNum2.substring(j, j+1));
                arr[i+j] += (n1*n2);
            }
            
        }

        int num = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < arr.length; i++)
        {
            num = arr[i]%10;
            carry = arr[i]/10;
            sb.insert(0, num%10);
            if(i < arr.length-1)
            {
                arr[i+1] += carry;
            }
        }
        while(sb.length()>0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        String res = sb.toString();
        if(res.equals(""))
            return "0";
    
        return sb.length()==0? "0" : sb.toString(); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution43 test = new Solution43();
		System.out.println(test.multiply("9", "9"));
	}

}
