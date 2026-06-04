class Pair{
    int num;
    int min;

    Pair(int num,int min){
        this.num=num;
        this.min=min;
    }
}

class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
            return;
        }
        int min=st.peek().min;
        if(val < min){
            st.push(new Pair(val,val));
        }
        else{
            st.push(new Pair(val,min));
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        st.pop();
    }
    
    public int top() {
        return st.peek().num;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
