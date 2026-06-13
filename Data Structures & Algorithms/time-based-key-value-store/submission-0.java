class TimeMap {

    class Pair{
        int num;
        String s;

        Pair(int num,String s){
            this.num=num;
            this.s=s;
        }
    }

    Map<String,List<Pair>> h;
    public TimeMap() {
        h=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        h.putIfAbsent(key,new ArrayList<>());
        h.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!h.containsKey(key)){
            return "";
        }

        int l=0;
        int r=h.get(key).size()-1;
        String ans="";
        List<Pair> list = h.get(key);


        while(l<=r){
            int mid=l+(r-l)/2;

            if(list.get(mid).num<=timestamp){
                ans=list.get(mid).s;
                l=mid+1;
            }

            else{
                r=mid-1;
            }
        }

        return ans;
    }
}
