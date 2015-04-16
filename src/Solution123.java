

public class Solution123 {
	/*
	 * O(n^2)
	 * Time limit exceeds
	 * Divide the array into half on each array element and find the max profit for each side
	 */
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 2; i < prices.length-2; i++)
        {
            int leftMin = Integer.MAX_VALUE;
            int leftMaxPro = 0;
            for(int l = 0; l < i; l++)
            {
                if(prices[l] < leftMin)
                    leftMin = prices[l];
                else
                    leftMaxPro = (prices[l] - leftMin);
            }
            
            int rightMin = Integer.MAX_VALUE;
            int rightMaxPro = 0;
            for(int r = 0; r < i; r++)
            {
                if(prices[r] < rightMin)
                    rightMin = prices[r];
                else
                    rightMaxPro = (prices[r] - rightMin);
            }
            
            if(maxProfit < (leftMaxPro+rightMaxPro))
                maxProfit = leftMaxPro+rightMaxPro;
            
        }
        
        return maxProfit;
        
        
    }
	
	public static int maxProfit2(int[] prices) {
        if(prices.length == 0)
            return 0;
        int maxProfit = 0;
        int[] leftProfits = new int[prices.length];
        int[] rightProfits = new int[prices.length];
        
        //left side
        int leftMin = Integer.MAX_VALUE;
        int leftMaxPro = 0;
        for(int l = 0; l < prices.length; l++)
        {
            if(prices[l] < leftMin)
                leftMin = prices[l];

            else
                leftMaxPro = Math.max((prices[l] - leftMin), leftMaxPro);
            
            leftProfits[l] = leftMaxPro;
        }
        
        //right side
        int rightMax = 0;
        int rightMaxPro = 0;
        for(int r = prices.length-1; r >=0 ; r--)
        {
            if(prices[r] > rightMax)
                rightMax = prices[r];
            else
                rightMaxPro = Math.max((rightMax - prices[r]), rightMaxPro);
                
            rightProfits[r] = rightMaxPro;
        }
        
        int leftOnlyProfit = leftProfits[prices.length-1]; // only one transaction
        
        for(int i = 0; i < prices.length-1; i++)
        {
            
            if(maxProfit < (leftProfits[i]+rightProfits[i+1]))
                maxProfit = leftProfits[i]+rightProfits[i+1];
        }
        
        return Math.max(maxProfit,leftOnlyProfit);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,4,1};
		System.out.println(maxProfit2(a));
	}
}
