package _11_stack_queue.optional.exercise.palindrome;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean checker(String string) {
        String[] str = string.toLowerCase().split(" ");
        System.out.println(Arrays.toString(str));
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
            queue.add(str[i]);
        }

        for (int i = 0; i < stack.size(); i++) {
            for (int j = 0; j < queue.size(); i++) {
                if (stack.pop().equals(queue.poll())) {
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;

    }
}
