class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int remainder = prefix % k;

            if (remainder < 0) 
                remainder += k;
            
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) 
                    return true;
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }
}