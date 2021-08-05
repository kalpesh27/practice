package com.door.app;
import java.util.Timer;
import java.util.TimerTask;



public class Remote {

    private DogDoor door;

    public Remote(DogDoor door){
        this.door = door;
    }
    public void pressButton(){
        System.out.println("Pressing the remote control button ");
        if(door.isOpen()){
            door.close();
        }else{
            //Its reaches here means that the door needs to be open.
            // we have the condition to check that the door doesnt stay open and closes automatically
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    door.close();
                    timer.cancel();
                }
            }, 5000);

            System.out.println(" The door is opening ");
            door.open();
            System.out.println(" The door has opened and will stay open for 5 secs ");
            try {
                Thread.sleep(5000);
                System.out.println(" The door is closing ");
                door.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
