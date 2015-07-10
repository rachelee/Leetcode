import java.util.Stack;
public class Solution71 {
    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<String>();
        int len = path.length();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 1; i < len; i++){
            char c = path.charAt(i);
            if(c == '/')
            {
                if(!path.substring(start, i).equals("/"))
                    stack.push(path.substring(start,i));
                start = i;
            }
            if(i == len-1)
            {
                if(!path.substring(start).equals("/"))
                    stack.push(path.substring(start));
            }
        }
        
        
        int upCount = 0;
        while(!stack.isEmpty())
        {
            String s = stack.pop();
            if(s.equals("/."))
                continue;
            else if(s.equals("/.."))
            {
                upCount++;
            }
            else
            {
                if(upCount == 0)
                {
                    sb.insert(0,s);
                }
                else    
                    upCount--;
            }
        }
        if(sb.length()==0)
            return "/";
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution71 test = new Solution71();
		System.out.println(test.simplifyPath("/."));
	}

}
