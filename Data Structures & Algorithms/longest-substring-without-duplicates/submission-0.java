class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Set<Character> h=new HashSet<>();

        int l=0;int r=0;
        // int dist=0;
        int maxLen=0;

        while( r < n){
            char ch=s.charAt(r);
            // h.add(ch);

            while(l < r && h.contains(ch)){
                h.remove(s.charAt(l));
                l++;
            }

            h.add(ch);
            maxLen=Math.max(maxLen,r-l+1);
            r++;

        }

        return maxLen;

    }
}
