class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];

        for(char c:t.toCharArray()){
            freq[c]++;
        }

        int[] freq2=new int[128];
        int min=Integer.MAX_VALUE;
        int l=0;
        int k=0;
        int n=s.length();

        for(int r=0; r<n; r++){
            char ch=s.charAt(r);

            freq2[ch]++;
            

            while(l < n && isSame(freq,freq2)){
                char c=s.charAt(l);
                // freq[c]--;
                freq2[c]--;

                if(min > r-l+1){
                    min=r-l+1;
                    k=l;
                }
                l++;
            }
        }

        if(min==Integer.MAX_VALUE) return "";
            return s.substring(k,k+min);
    }
    

    public static boolean isSame(int[] a,int[] b){
        for(int i=0;i < 128;i++){
            if(b[i]<a[i]) return false;
        }

        return true;
    }
}

