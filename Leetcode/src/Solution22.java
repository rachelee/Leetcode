import java.util.List;
import java.util.ArrayList;
public class Solution22 {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        int left = n-1;
        int right = n;
        String s = "(";
        recGenerate(left, right, s, res);
        return res;
    }
    private void recGenerate(int left, int right, String s, List<String> res){
        if(left == 0)
        {
            while(right != 0)
            {
                s = s+")";
                right--;
            }
            res.add(s);
        }
        else
        {
            if(left <= right)
            {
                recGenerate(left-1, right, s+"(", res);
                recGenerate(left, right-1, s+")", res);
            }
            
        }
    }
}
