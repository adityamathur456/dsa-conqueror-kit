class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        if (!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int transitions = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return transitions;

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;
                        
                        String str = new String(arr);
                        
                        if (set.contains(str)) {
                            queue.offer(str);
                            set.remove(str);
                        }
                    }
                }
            }

            transitions++;
        }

        return 0;
    }
}
