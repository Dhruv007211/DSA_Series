/*
═══════════════════════════════════════════════════════════════
📅 DAY 7
📚 TOPIC : ARRAYS

❓ Ques 16.) Best Time to Buy and Sell Stock

Problem Statement:

You are given an array prices where:

prices[i]

represents stock price on day i.

Choose one day to buy
and a later day to sell.

Return maximum profit.

If no profit is possible,
return 0.

Example:

Input:

prices = [7,1,5,3,6,4]

Output:

5

Explanation:

Buy at 1
Sell at 6

Profit = 5

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Try every possible buy day.
2. Try every possible sell day.
3. Calculate profit.
4. Store maximum profit.

Dry Run:

prices = [7,1,5,3,6,4]

Buy = 1

Sell = 5

Profit = 4

-------------------------------

Buy = 1

Sell = 6

Profit = 5

Maximum = 5

Time Complexity : O(N²)

Space Complexity : O(1)

Pattern Used:
→ Nested Loops
→ Pair Comparison

═══════════════════════════════════════════════════════════════
*/

class StockBuySellBrute {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {

            for(int j = i + 1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];

                maxProfit =
                    Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH
(Minimum Price Tracking)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Profit

=
Selling Price
-
Buying Price

To maximize profit:

Need

Maximum Selling Price
-
Minimum Buying Price

Idea:

While traversing:

1. Keep track of minimum price seen so far.
2. Calculate profit if sold today.
3. Update maximum profit.

═══════════════════════════════════════════════════════════════

Dry Run:

prices = [7,1,5,3,6,4]

--------------------------------

Day 1

Price = 7

minPrice = 7

profit = 0

maxProfit = 0

--------------------------------

Day 2

Price = 1

minPrice = 1

profit = 0

--------------------------------

Day 3

Price = 5

profit = 5 - 1 = 4

maxProfit = 4

--------------------------------

Day 4

Price = 3

profit = 3 - 1 = 2

--------------------------------

Day 5

Price = 6

profit = 6 - 1 = 5

maxProfit = 5

--------------------------------

Day 6

Price = 4

profit = 4 - 1 = 3

Answer = 5

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity : O(1)

Pattern Used:
→ Running Minimum
→ Greedy

Why Optimal?

Each element visited only once.

No nested loops required.

═══════════════════════════════════════════════════════════════
*/

class StockBuySellOptimal {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for(int price : prices) {

            minPrice =
                Math.min(minPrice, price);

            int profit =
                price - minPrice;

            maxProfit =
                Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
