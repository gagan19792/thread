package com.gagan.learn.threads;

public class CustomThread extends Thread{

    @Override
    public void run() {
        for(int i=0; i<5;i++){
            try{
                System.out.print(1);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
