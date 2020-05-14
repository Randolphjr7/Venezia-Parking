package veneziaparking;

import java.util.StringTokenizer;

/**
 *
 * @author rando
 */
public class Car {
    
    private final String licensePlate, parkingStatus;
    private int numofMoves; // counter for the # of times moved to temporary lot
    
    public Car(String plate, String status){
        licensePlate = plate;
        parkingStatus = status;
        numofMoves = 0; // does not count "ARRIVE" and "DEPART" moves
    }
    
    String parkingStatus(){
        return parkingStatus;
    }
    
    boolean equalTo(Car c){
        if(c.licensePlate == licensePlate){
            return true;
        }
        return false;
    }
    
    void increment(){
        numofMoves++;
    }
    
    int getnumofMoves(){
        return numofMoves;
    }
    
    String carPlate(){
        return licensePlate;
    }
    
    @Override
    public String toString(){
        return "\n" + "License Plate: " + licensePlate + "  " + "Parking Status:"
                + " " + parkingStatus;
    }
}
