class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            j = Math.max(j, i + minJump);
            while (j < Math.min(i + maxJump + 1, n)) {
                if (s.charAt(j) == '0') {
                    dp[j] = true;
                }
                j++;
            }
        }

        return dp[n - 1];
    }
}