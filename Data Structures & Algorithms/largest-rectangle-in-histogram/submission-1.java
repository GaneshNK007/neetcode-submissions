class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;

        int[] ng=new int[n];
        int[] pg=new int[n];

        Stack<Integer> st=new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            ng[i]=(st.isEmpty())? n:st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            pg[i]=(st.isEmpty())? -1:st.peek();
            st.push(i);
        }

        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int area=0;
            area=(ng[i]-pg[i]-1)*heights[i];
            

            maxArea=Math.max(area,maxArea);
        }

        return maxArea;
    }
}
