
public class Solution151 {
	public String reverseWords(String s) {
        if(s == null ||s.length() == 0)
            return s;
            
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();
        
        for(int i = arr.length -1; i >= 0; i--)
        {
            if(!arr[i].equals(""))
            {
                res.append(arr[i]).append(" ");
            }
        }
        
        String strRes = res.toString();
        if(strRes.length() == 0)
            return "";
        else
            return strRes.substring(0, strRes.length()-1);
    }
}
