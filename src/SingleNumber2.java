

public class SingleNumber2 {
	public int singleNumber(int[] A) {  
        if(A.length == 0||A==null)  
           return 0;
       
       int[] cnt = new int[32];  
       for(int i = 0; i < A.length; i++){  
           for(int j = 0; j < 32; j++){  
               if( (A[i]>>j & 1) ==1){  
                   cnt[j]++;  
               }  
           }  
       }  
       int res = 0;  
       for(int i = 0; i < 32; i++){  
           res += (cnt[i]%3 << i);
         //res |= (cnt[i]%3 << i);
       }  
       cnt = null;  
       return res;  
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
