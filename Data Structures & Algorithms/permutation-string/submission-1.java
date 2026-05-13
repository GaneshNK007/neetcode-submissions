class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        if(n1 > n2) return false;
        int[] f1=new int[26];
        int[] f2=new int[26];

        for(char ch:s1.toCharArray()){
            f1[ch-'a']++;
        }


        for(int i=0;i<n2;i++){
            char c=s2.charAt(i);

            f2[c - 'a']++;

            if(i >= n1){
                char ch=s2.charAt(i-n1);
                f2[ch - 'a']--;
            }

            if(isSame(f1,f2)){
                return true;
            }
        }

        return false;
    }


    public boolean isSame(int[] a,int[] b){

        for(int i=0; i<26; i++){
            if(a[i]!=b[i]) return false;
        }

        return true;
    }
}
