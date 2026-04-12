

public class Solution {

    public int appendCharacters(String s, String t) {

            int n = s.length();
                    int m = t.length();

                            int[][] store = new int[n][26];

                                    // Initialize with invalid index
                                            for (int[] row : store) {
                                                        Arrays.fill(row, n + 1);
                                                                }

                                                                        // Base case for last character
                                                                                store[n - 1][s.charAt(n - 1) - 'a'] = n - 1;

                                                                                        // Fill table from right to left
                                                                                                for (int i = n - 2; i >= 0; i--) {
                                                                                                            store[i] = store[i + 1].clone();
                                                                                                                        store[i][s.charAt(i) - 'a'] = i;
                                                                                                                                }

                                                                                                                                        int i = 0;
                                                                                                                                                int j = 0;

                                                                                                                                                        // Try to match t in s using precomputed table
                                                                                                                                                                while (i < n && j < m) {

                                                                                                                                                                            if (store[i][t.charAt(j) - 'a'] == n + 1) {
                                                                                                                                                                                            break;
                                                                                                                                                                                                        }

                                                                                                                                                                                                                    i = store[i][t.charAt(j) - 'a'] + 1;
                                                                                                                                                                                                                                j++;
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                // Remaining characters to append
                                                                                                                                                                                                                                                        return m - j;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            }