
public class Solution91 {
	//rec way of solving the problem
    public int numDecodings(String s) {
        int[] arr = new int[s.length()+1];
        if(s == null || s.length() == 0)
            return 0;
            
        if(s.charAt(0)=='0') {  
            return 0;  
        }  
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++)
        {   
        
            if(s.charAt(i-1) != '0')
            {
                arr[i] = arr[i-1];
            }
            if(s.charAt(i-2) != '0')
            {
                int tmp = Integer.parseInt(s.substring(i-2, i));
                if(tmp >= 1 && tmp <=26)
                    arr[i]+= arr[i-2];
            }
                
        }
        return arr[s.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "101";
		Solution91 test = new Solution91();
		System.out.println(test.numDecodings(s));
	}

}
