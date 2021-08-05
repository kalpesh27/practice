package com.door.app;


public class DogDoorTest {

    public static void main(String args[]){

        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        System.out.println(" Dog barks to go out \n");
        remote.pressButton();
//        System.out.println(" Dog has gone outside \n");
//        remote.pressButton();
        System.out.println(" Dog Wants to come inside \n");
        remote.pressButton();
//        System.out.println(" Dog is already inside so close the door \n");
//        remote.pressButton();
    }
}
