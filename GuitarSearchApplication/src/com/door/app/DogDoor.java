package com.door.app;

public class DogDoor {
    private boolean open;

    public DogDoor(){
        this.open = false;
    }

    public void close(){
        System.out.println(" The dog door closed ");
        this.open = false;
    }

    public void open(){
        System.out.println(" The dog door opens ");
        this.open = true;
    }

    public boolean isOpen() {
        return open;
    }

}
