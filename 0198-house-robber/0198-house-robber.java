class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,0,n,dp);
    }
    public int solve(int [] nums ,int i , int end, int[]dp ){
        int n = nums.length;
        if(i>=n) return 0;
        if(dp[i]!=-1)return dp[i];
        int take = nums[i]+ solve(nums,i+2,n,dp);
        int skip = solve(nums, i+1, n,dp);
        dp[i] = Math.max(take,skip);
        return dp[i];
    }
}