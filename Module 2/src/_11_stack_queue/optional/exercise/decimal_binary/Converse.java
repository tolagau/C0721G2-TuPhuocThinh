package _11_stack_queue.optional.exercise.decimal_binary;

import java.util.Stack;

public class Converse {
    public String converse(int num){
        Stack <Integer> decimal = new Stack<>();
        String str = "";
        int cout = 0;
        while (num > 0){
            int so = num %2;
            decimal.push(so);
            num = num /2;
            cout++;
        }
        for (int i = 0; i < cout; i++) {
            str += decimal.peek();
            decimal.pop();
        }
        return str;
    }
}
