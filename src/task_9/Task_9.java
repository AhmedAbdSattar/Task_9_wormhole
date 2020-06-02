
package task_9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class Task_9 {

    
    public static void main(String[] args) {
        //warnning before enter the number of the planets
        JOptionPane.showMessageDialog(null,"please Enter time values in file first please","warnning",2);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of planets :");
        int planetsNum = sc.nextInt();
        int graph[][]=new int[planetsNum][planetsNum]; //create graph

     
        try {
      BufferedReader input = new BufferedReader ( new FileReader ( "time_values.txt" ) ); //read the time between planets 
      Scanner myReader = new Scanner(input);
      int data;
      while (myReader.hasNextInt()) {
           for (int i=0 ;i<planetsNum ;i++){
            for(int j =0 ;j<planetsNum;j++){
                 data = myReader.nextInt();
                graph[i][j]=data;
            }
           }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    JOptionPane.showMessageDialog(null,"please source and destination from 0 to "+(planetsNum-1),"warnning",2);
           path Run = new path () ;
           System.out.print("Enter the source planet:");
           int source = sc.nextInt();
           System.out.print("Enter the destination planet:");
           int destination=sc.nextInt();
           if (source >(planetsNum-1) || destination >(planetsNum-1)||source <0 || destination < 0){
                 JOptionPane.showMessageDialog(null,"please source and destination from 0 to "+(planetsNum-1),"Error",0);
                 System.exit(0);
           }
           Run.FindShortest_Path(graph,source,destination); //function void take 3 parameters 2d array graph and 2 integers
               
    
    }
}
