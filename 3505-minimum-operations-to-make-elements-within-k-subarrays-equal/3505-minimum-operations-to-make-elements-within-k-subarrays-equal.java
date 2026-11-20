class Solution {
    int n,x,k;
    TreeMap<Integer,Integer> left=new TreeMap<>();
    TreeMap<Integer,Integer> right=new TreeMap<>();
    int leftSize=0,rightSize=0;
    long leftSum=0,rightSum=0;

    public long minOperations(int[] nums,int x,int k) {
        n=nums.length;
        long[] cost=new long[n-x+1];

        for(int i=0;i<n;i++){
            add(nums[i]);
            if(i>=x) remove(nums[i-x]);
            if(i>=x-1){
                int median=left.lastKey();
                cost[i-x+1]=(long)median*leftSize-leftSum+rightSum-(long)median*rightSize;
            }
        }

        long INF=Long.MAX_VALUE/4;
        long[][] dp=new long[k+1][n+1];

        for(int j=1;j<=k;j++) Arrays.fill(dp[j],INF);

        for(int j=1;j<=k;j++){
            for(int i=1;i<=n;i++){
                dp[j][i]=dp[j][i-1];
                if(i>=x && dp[j-1][i-x]!=INF){
                    dp[j][i] = Math.min(dp[j][i], dp[j-1][i-x]+cost[i-x]);
                }
            }
        }
        return dp[k][n];
    }

    void add(int val){
        if(left.isEmpty()||val<=left.lastKey()){
            left.merge(val,1,Integer::sum);
            leftSize++;
            leftSum+=val;
        }else{
            right.merge(val,1,Integer::sum);
            rightSize++;
            rightSum+=val;
        }
        balance();
    }

    void remove(int val){
        if(left.containsKey(val)){
            erase(left,val);
            leftSize--;
            leftSum-=val;
        }else{
            erase(right,val);
            rightSize--;
            rightSum-=val;
        }
        balance();
    }

    void erase(TreeMap<Integer,Integer> map,int val){
        if(map.get(val)==1) map.remove(val);
        else map.put(val,map.get(val)-1);
    }

    void balance(){
        while(leftSize<rightSize){
            int val=right.firstKey();
            erase(right,val);
            rightSize--;
            rightSum-=val;
            left.merge(val,1,Integer::sum);
            leftSize++;
            leftSum+=val;
        }
        while(leftSize>rightSize+1){
            int val=left.lastKey();
            erase(left,val);
            leftSize--;
            leftSum-=val;
            right.merge(val,1,Integer::sum);
            rightSize++;
            rightSum+=val;
        }
    }
}