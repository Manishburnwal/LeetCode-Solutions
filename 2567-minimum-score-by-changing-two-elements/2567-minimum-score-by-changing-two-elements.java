class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int mini = Math.min((nums[n-3]-nums[0]),(nums[n-1]-nums[2]));
        return Math.min(mini,(nums[n-2]-nums[1]));
    }
}