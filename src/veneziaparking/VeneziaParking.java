package veneziaparking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.StringTokenizer;
/**
 *
 * @author rando
 */
public class VeneziaParking {
    


    public static void main(String[] args) throws FileNotFoundException {
        
  
        Garage veneziaGarage = new Garage();
        
        Scanner fileIn = new Scanner( new File ("garage.txt") ) ;
        String content = new Scanner(new File("garage.txt")).useDelimiter("\\Z").next();
        
   


      
         veneziaGarage.firstChop(content); 

          
    } 
   
}
