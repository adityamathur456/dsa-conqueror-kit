class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = nums.clone();
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int maxSum = dp[0];
        for (int sum : dp) {
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}
