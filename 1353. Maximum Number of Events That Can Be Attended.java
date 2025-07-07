import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, n = events.length;
        int day = 0, attended = 0;

        while (i < n || !minHeap.isEmpty()) {
            // Move to next available day
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
                day++;
            }
        }

        return attended;
    }
}
