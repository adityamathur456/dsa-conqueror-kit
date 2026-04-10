

class Solution {
    public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
                    backtrack(1, n, k, new ArrayList<>(), result);
                            return result;
                                }

                                    private void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
                                            // base case
                                                    if (temp.size() == k) {
                                                                result.add(new ArrayList<>(temp));
                                                                            return;
                                                                                    }

                                                                                            // generate combinations
                                                                                                    for (int i = start; i <= n; i++) {
                                                                                                                temp.add(i);                       // choose
                                                                                                                            backtrack(i + 1, n, k, temp, result); // explore
                                                                                                                                        temp.remove(temp.size() - 1);      // un-choose (backtrack)
                                                                                                                                                }
                                                                                                                                                    }
                                                                                                                                                    }