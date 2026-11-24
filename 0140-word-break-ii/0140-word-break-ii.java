class Solution {
    Map<Integer,List<String>> dp = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        return solve(s,0,set);
    }

    private List<String> solve(String s, int idx, Set<String> set){
        if(idx==s.length()){
            return new ArrayList<>(List.of(""));
        }
        if(dp.containsKey(idx)) {
            return dp.get(idx);
        }

        List<String> ans=new ArrayList<>();

        for(int i=idx+1;i<=s.length();i++){
            String word =  s.substring(idx,i);
            if(set.contains(word)) {
                List<String> remaining = solve(s,i,set);
                for(String str:remaining){
                    if(str.isEmpty()){
                        ans.add(word);
                    } else {
                        ans.add(word+" "+str);
                    }
                }
            }
        }
        dp.put(idx,ans);
        return ans;
    }
}