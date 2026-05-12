class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();

        int l=0;
        int r=0;
        int maxLen=0;
        Map<Character,Integer> h=new HashMap<>();
        int maxFreq=0;

        while( r < n){
            char ch=s.charAt(r);

            h.put(ch,h.getOrDefault(ch,0)+1);

            maxFreq=Math.max(maxFreq,h.get(ch));

            while((r-l+1) - maxFreq > k){
                char c=s.charAt(l);

                h.put(c,h.get(c)-1);
                l++;
            }

            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }

        return maxLen;
    }
}
