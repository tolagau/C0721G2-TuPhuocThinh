package _04_oop_java.exercise.student_manager;

import java.util.Scanner;

public class Manager {
    Student studentList[] = new Student[100];

    public void add() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scr.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(scr.nextLine());
        System.out.println("Enter address: ");
        String addr = scr.nextLine();
        Student student = new Student(name, age, addr);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                studentList[i] = student;
                break;
            }
        }
    }
    public void display(){
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.print(studentList[i].toString());
            } else {
                break;
            }
        }
    }
    public void edit(String student){
        for (int i = 0; i < studentList.length;i++){

        }

    }
    public void delete(String student){

    }
    public void search(String student){

    }
}

