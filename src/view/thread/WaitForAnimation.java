/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.thread;

/**
 *
 * @author Mitch
 */
public class WaitForAnimation extends Thread {

    private int laps;
    public boolean shouldRun; // notez le public !

    public WaitForAnimation(int laps) {
        this.laps = laps;
        shouldRun = true;
    }

    public void run() {
        while (shouldRun) {
            try {
                sleep(laps / 1);
//                System.out.println("MyTimer: run");
//                sleep(laps / 200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
