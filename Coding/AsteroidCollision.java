

//https://leetcode.com/problems/asteroid-collision/description/

import java.util.*;

class AsteroidCollision {
    public int[] asteroidCollisions(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean alive = true;

            // Only potential collisions: right-moving (stack) vs left-moving (a)
            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -a) {
                    // Stack top asteroid is smaller → it explodes
                    stack.pop();
                    // Keep checking, because new top may also collide
                } else if (top == -a) {
                    // Both are equal → both explode
                    stack.pop();
                    alive = false;
                } else {
                    // Stack top is bigger → current asteroid explodes
                    alive = false;
                }
            }

            // If current asteroid is still alive, add to stack
            if (alive) {
                stack.push(a);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
