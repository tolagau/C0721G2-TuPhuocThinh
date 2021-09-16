package _11_stack_queue.exercise.reverse;
import java.util.Arrays;

import java.util.Stack;

public class ReverseIntAndStr {
    public static void reverseInt(int [] arrNum){
        Stack<Integer> arrInter = new Stack();
        for (int i = 0; i<arrNum.length;i++){
            arrInter.push(arrNum[i]);
        }
        for (int i =0;i<arrNum.length;i++){
            arrNum[i]=arrInter.pop();
        }
    }
    public static String reverseStr(String string){
        String[] str = string.split("");
        Stack<String> arrStr = new Stack<>();
        for (int i =0;i<str.length;i++){
            arrStr.push(str[i]);
        }
        String newString = "";
        for (int i = 0; i < str.length; i++) {
            newString += arrStr.peek();
            arrStr.pop();
        }
        return newString;
    }
    public static void main(String[] args) {
        int[] array = {1,5,3,5,6,7,23,4};
        reverseInt(array);
        System.out.println(Arrays.toString(array));
        String string = "TuThinh";
        System.out.println(reverseStr(string));
    }

}
