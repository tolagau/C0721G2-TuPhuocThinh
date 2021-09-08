package _04_oop_java.exercise.student_manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Manager studentManagement = new Manager();
        boolean flag = true;
        while (flag) {
            System.out.println("List of selection\n" +
                    "1. Add \n" +
                    "2. Display \n" +
                    "3. Delete \n" +
                    "4. Edit \n" +
                    "5. Search \n" +
                    "6. Exit \n" );
            System.out.println("Enter your selection");
            int selection = Integer.parseInt(scr.nextLine());
            switch(selection) {
                case 1:
                    studentManagement.add();
                case 2:
                    studentManagement.display();
                case 3:
                    studentManagement.delete("Nam");
                case 4:
                    studentManagement.edit("Thái");
                case 5:
                    studentManagement.search("Hải");
                case 6:
                    flag = false;
                    break;
            }
        }
    }
}
