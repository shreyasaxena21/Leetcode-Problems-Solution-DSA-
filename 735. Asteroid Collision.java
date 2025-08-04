class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            boolean isSameSize = false;  // reset this every iteration
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if (Math.abs(asteroids[i]) > Math.abs(stack.peek())) {
                    stack.pop(); // continue while loop to check next
                    continue;
                } else if (Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                    stack.pop(); // both explode
                    isSameSize = true;
                    break;
                } else {
                    // Current is smaller, it explodes
                    isSameSize = true;
                    break;
                }
            }
            if (!isSameSize && (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0)) {
                stack.push(asteroids[i]);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
