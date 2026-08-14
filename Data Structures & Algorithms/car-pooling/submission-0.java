public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> points = new ArrayList<>();
        for (int[] trip : trips) {
            int passengers = trip[0], start = trip[1], end = trip[2];
            points.add(new int[]{start, passengers});
            points.add(new int[]{end, -passengers});
        }

        points.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int curPass = 0;
        for (int[] point : points) {
            curPass += point[1];
            if (curPass > capacity) {
                return false;
            }
        }

        return true;
    }
}