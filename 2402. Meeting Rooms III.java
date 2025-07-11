import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap for available rooms (sorted by room number)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) availableRooms.offer(i);

        // Min-heap for busy rooms: (endTime, roomNumber)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));

        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long duration = end - start;

            // Free up rooms that have completed by now
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                busyRooms.offer(new long[]{start + duration, room});
                meetingCount[room]++;
            } else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                busyRooms.offer(new long[]{newEnd, room});
                meetingCount[room]++;
            }
        }

        // Find the room with the maximum meeting count
        int maxMeetings = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
