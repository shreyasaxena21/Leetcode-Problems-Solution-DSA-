import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0; // pointer for players
        int j = 0; // pointer for trainers
        int matchCount = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matchCount++;
                i++;
                j++;
            } else {
                j++; // current trainer is not strong enough, check next
            }
        }

        return matchCount;
    }
}
