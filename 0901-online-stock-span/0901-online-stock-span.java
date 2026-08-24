class StockSpanner {

    // stack stores {price, span}
    ArrayList<Integer>ans;

    public StockSpanner() {

       ans=new ArrayList<>();
    }
    
    public int next(int price) {

        int span = 1;

        // remove smaller/equal prices
       for(int i=ans.size()-1;i>=0;i--){
        if(ans.get(i)<=price)span++;
else{
    break;
}
       }
            // span += st.pop()[1];
            ans.add(price);
        

        // push current price and span
  

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 *
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */