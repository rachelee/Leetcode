import java.util.HashMap;
public class Solution13 {
	public int romanToInt(String s) {
        int prev = 0;
        int cur = 0;
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
        {
            cur = getInt(s.substring(i,i+1));
            if(cur <= prev)
                sum += cur;
            else
                sum = sum + cur - 2*prev;
            prev = cur;
        }
        return sum;
    }
    private int getInt(String roman){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        return map.get(roman);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
