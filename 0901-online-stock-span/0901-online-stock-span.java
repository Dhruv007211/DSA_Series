class StockSpanner {

    // stack stores {price, span}
    Stack<int[]> st;

    public StockSpanner() {

        st = new Stack<>();
    }
    
    public int next(int price) {

        int span = 1;

        // remove smaller/equal prices
        while(!st.isEmpty() &&
              st.peek()[0] <= price) {

            span += st.pop()[1];
        }

        // push current price and span
        st.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 *
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */