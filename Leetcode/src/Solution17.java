import java.util.*;
public class Solution17 {
	//DFS
    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        recLetters(digits, map, sb, res);
        return res;
    }
    private static void recLetters(String digits, Map<Character, String> map, StringBuilder sb, List<String> res){
        if(digits.length() == 0)
        {
        	if(sb.length() == 0)
                return;
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(0));
        for(int i = 0; i < letters.length(); i++)
        {
            sb.append(letters.charAt(i));
            recLetters(digits.substring(1), map, sb, res);
            sb.setLength(sb.length()-1);
        }
        
        
    }
    //BFS
	public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        char c = digits.charAt(0);
        res = getLetters(c);
        List<String> tempRes = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for(int i = 1; i < digits.length(); i++)
        {
            temp = getLetters(digits.charAt(i));
            for(String s: res)
            {
                for(String x:temp)
                {
                    s = s + x;
                    tempRes.add(s);
                    s = s.substring(0, s.length()-x.length());
                }
            }
            res = tempRes;
            tempRes = new ArrayList<>();
        }
        return res;
        
    }
    private List<String> getLetters(char digit){
        List<String> letters;
        Map<Character, List<String>> map = new HashMap<>();
        map.put('0', new ArrayList<String>());
        map.put('1', new ArrayList<String>());
        map.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        
        return map.get(digit);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = letterCombinations("2");
		System.out.println(res);
	}

}
