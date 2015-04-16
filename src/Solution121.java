

public class Solution121 {
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, maxDiff = 0;
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < min)
                min = prices[i];
            else
            {
                int diff = prices[i] - min;
                if(diff > maxDiff)
                    maxDiff = diff;
            }
        }
        
        return maxDiff;
    }
}
