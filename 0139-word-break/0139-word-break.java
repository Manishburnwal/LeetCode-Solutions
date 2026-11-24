class Solution {
    int n;
    private Boolean[] t;
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        t = new Boolean[s.length()];
        return solve(0,s,wordDict);
    }
    public boolean solve(int idx, String s, List<String> wordDict){
        if(idx>=n) return true;
        if(t[idx]!=null) return t[idx];
        for(int k=idx+1;k<=n;k++){
            String str = s.substring(idx,k);
            if(wordDict.contains(str) && solve(k,s,wordDict)){
                return t[idx]=true;
            }
        }
        return t[idx]=false;
    }
}