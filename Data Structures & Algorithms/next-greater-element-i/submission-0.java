class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> monotonicStack = new Stack<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() <= nums2[i])
                monotonicStack.pop();
            
            nextGreaterMap.put(
                nums2[i], 
                monotonicStack.isEmpty() ? -1 : monotonicStack.peek()
            );

            monotonicStack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}