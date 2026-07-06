class Solution {
    public int maxArea(int[] height) {
        int max=0;
       int i=0;
           int j=height.length-1;
           while(i<=j){
                int w=j-i;
                int h=Math.min(height[j],height[i]);
                int area=w*h;
            
            max=Math.max(area,max);
            if(height[i]<height[j])i++;
            else{j--;}
        }
        return max;
    }
}