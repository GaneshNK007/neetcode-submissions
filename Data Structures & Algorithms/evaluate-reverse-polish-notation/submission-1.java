class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s1=new Stack<>();

        for(String s:tokens){
            if(s.equals("+")){
                int a=s1.pop();
                int b=s1.pop();
                s1.push(a+b);
            }
            else if(s.equals("-")){
                int a=s1.pop();
                int b=s1.pop();
                s1.push(b-a);
            }
            else if(s.equals("*")){
                int a=s1.pop();
                int b=s1.pop();
                s1.push(b*a);
            }
            else if(s.equals("/")){
                int a=s1.pop();
                int b=s1.pop();
                s1.push(b/a);
            }
            else{
                s1.push(Integer.parseInt(s));
            }
        }

        return s1.peek();
    }
}
