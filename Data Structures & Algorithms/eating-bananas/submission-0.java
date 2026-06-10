class Solution {

    public boolean isPossible(int[] p,int a,int h){
        int sum=0;

        for(int num:p){
            sum+=(int)Math.ceil((double)num/a);
        }

        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=Arrays.stream(piles).max().getAsInt();
        int k=0;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(isPossible(piles,mid,h)){
                k=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        return k;

    }
}
