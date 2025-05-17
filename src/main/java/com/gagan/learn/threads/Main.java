package com.gagan.learn.threads;

import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());
        System.out.println(currentThread);
        printThreadState(currentThread);

        //Creating Thread by extending Thread class
        CustomThread customThread = new CustomThread();
        customThread.start();

        //Creating Thread using Runnable interface
        Runnable runnable = ()->{
          for(int i=1; i<=8; i++){
              System.out.print(8);
              try {
                  TimeUnit.MILLISECONDS.sleep((250));
              }catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };

        Thread newThread = new Thread(runnable);
        newThread.start();

        for(int i =1; i<=3; i++){
            System.out.print(0);
            try {
                TimeUnit.SECONDS.sleep((1));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printThreadState(Thread thread){
        System.out.println("---------------------------");
        System.out.println("Thread Id : "+thread.threadId());
        System.out.println("Thread Name :"+thread.getName());
        System.out.println("Thread Priority : "+thread.getPriority());
        System.out.println("Thread State : "+thread.getState());
        System.out.println("Thread Group : "+thread.getThreadGroup());
        System.out.println("Thread Is Alive : "+thread.isAlive());
        System.out.println("---------------------------");
    }
}