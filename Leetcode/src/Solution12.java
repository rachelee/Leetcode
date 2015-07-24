import java.util.HashMap;
public class Solution12 {
	public String intToRoman1(int num) {
        int div = 1; 
        while(num/div >= 10)
        {
            div *=10;
        }
        int startNum;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            startNum = num/div;
            String num1 = getInt(div);
            String num2 = getInt(5*div);
            if(startNum >= 1 && startNum <4)
            {
                while(startNum > 0)
                {
                    sb.append(num1);
                    startNum--;
                }
            }
            else if(startNum >= 5 && startNum <9)
            {
                
                sb.append(num2);
                while(startNum - 5 != 0)
                {
                	sb.append(num1);
                	startNum--;
                }
                
            }
            else if(startNum == 9){
                String s1 = num1;
                String s2 = getInt(div*10);
                sb.append(s1);
                sb.append(s2);
            }
            else if(startNum == 4){
                String s1 = num1;
                String s2 = getInt(div*5);
                sb.append(s1);
                sb.append(s2);
            }
            else{
                
            }
                
            num = num%div;
            div = div/10;
        }
        return sb.toString();
    }
    private String getInt(int roman){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        return map.get(roman);
    }
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = {1000,900,500,400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        while(num != 0){
            if(num >= number[i])
            {
                sb.append(roman[i]);
                num -= number[i];
            }
            else
                i++;
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution12 test = new Solution12();
		System.out.println(test.intToRoman(51));
	}

}
