package veneziaparking;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

/**
 *
 * @author rando
 */
public class Garage {
    
    private StringTokenizer tokenizer, bokenizer;
    private static final int CAPACITY = 10;
    private Car[] garage;
    private int count;


    public Garage() throws FileNotFoundException {
        garage = new Car[CAPACITY];
        count = 0;
        PrintStream myconsole = new PrintStream(new File("output.txt"));
        //creates a new ".txt" file called Output ^^
        System.setOut(myconsole);  //saves output to file insetad of console
        System.out.println("Output for Garage:\n\n\n");
    }
    
    /**
    * This method chops up the file input one unit at a time consisting of two
    * components of car's tag AND operation ex: "JAVA001 ARRIVE"
    * @param file 
    */
    public void firstChop(String file) throws FileNotFoundException{
    
        System.out.println("Garage Output Log");
        System.out.println("");
        tokenizer = new StringTokenizer(file, "\n");
        for(int i = 0; i <= file.length(); i++){ 
            if(tokenizer.hasMoreTokens()){
                String unit = tokenizer.nextToken();
                secondChop(unit);
            }
        }
        
    }
    
    /**
    * chops up again the file input, into two separate variables to hold car's
    * tag and the car's operation(ARRIVE/DEPART)
    * @param input 
    */
    public void secondChop(String input){
        bokenizer = new StringTokenizer(input, " ");
        String tag = bokenizer.nextToken();
        String operation = bokenizer.nextToken();
        processing(tag, operation);  
    }
    
    /**
    * This method initializes Car objects and adds them to the Array garage
    * @param tag
    * @param operation 
    */
    public void processing(String tag, String operation){
        Car ford = new Car(tag, operation);
        switch(operation){
            case "ARRIVE":
                arrive(ford);
                break;
            case "DEPART":
                depart(ford);
                break;
        }
    }


    
    // add car to garage
    public void arrive(Car car){
        if((car.parkingStatus().equals("ARRIVE")) && (count == 0)){
            garage[count++] = car; 
            System.out.println("Processed: " + car.toString());
            System.out.println("Welcome to Venezia Hotel Garage -" + car.carPlate());
        }
        else if((car.parkingStatus().equals("ARRIVE")) && (count < CAPACITY)){
            garage[count++] = car;
            System.out.println("Processed: " + car.toString());
            System.out.println("Welcome to Venezia Hotel Garage -" + car.carPlate());
        }
        else if((car.parkingStatus().equals("ARRIVE")) && (count == CAPACITY)){
            System.out.println("Processed: " + car.toString());
            System.out.println("Sorry " + car.carPlate() + " Garage is FULL");  
        }   
    }
    
    // remove car from garage
    public void depart(Car car){
        boolean found = false;
        int targetIndex = 0;
        System.out.println("System.out");
        while(targetIndex < count && !found){
            System.out.println("System.out");
            for (Car vehicle : garage) {
                if(car.carPlate().equals(vehicle.carPlate())){ // i tried to used equalTo() method in Car class. Why did it not work?
                    found = true;
                    System.out.println("System.out");
                    break;
                }
                else{
                    System.out.println("System.out");
                    targetIndex++;
                    System.out.println("System.out");
                }
            }              
        }
        if(!found){
            System.out.println("Car was requested to depart but no match found.");
        }
        if(found){
            for(int i = 0; i < count; i++){
                Car blah = garage[i];
                System.out.println("PRINTING CARS IN GARAGE BEFORE- " + blah.carPlate());
            }
            System.out.println("");
            if(targetIndex == 0){
                for(int i = targetIndex; i < count - 1; i++){
                    garage[i] = garage[i + 1];
            }
            count --;
            System.out.println("Car: " + car.carPlate() + " was removed successfully.");
            }
            else if(targetIndex > 0){
                for(int i = 0; i < targetIndex; i++){
                    garage[i].increment();
                    System.out.println("Car parked at garage index [" + garage[i] + "] was moved out temporarily. "
                            + "it's numofMoves counter: " + garage[i].getnumofMoves());
                }
                for(int i = targetIndex; i < count -1; i++){
                    garage[i] = garage[i +1];
                }
                count--;
            }
            for(int i = 0; i < count; i++){
                Car blah = garage[i];
                System.out.println("PRINTING CARS IN GARAGE AFTER- " + blah.carPlate());
            }
            System.out.println("");
        }
    }
    
    
}
