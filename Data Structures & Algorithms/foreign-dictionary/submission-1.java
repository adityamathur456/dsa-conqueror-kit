class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; j++) {
                char u = first.charAt(j);
                char v = second.charAt(j);

                if (u != v) {
                    if (!graph.get(u).contains(v)) {   
                        graph.get(u).add(v);
                        indegree.put(v, indegree.get(v) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()) {
            char node = queue.poll();
            ans.append(node);

            for (char neighbour : graph.get(node)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);

                if (indegree.get(neighbour) == 0) 
                    queue.offer(neighbour);
            }
        }

        // Cycle exists
        if (ans.length() != indegree.size()) {
            return "";
        }

        return ans.toString();
    }
}
