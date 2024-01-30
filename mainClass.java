import java.util.ArrayList;
import java.util.Scanner;
public class mainClass {

    public void main (String[] args){
    pets pet1 = new pets();
    owner owner1 = new owner();


    System.out.println("what is your name?");
    Scanner ownerName = new Scanner(System.in);
    owner1.name = ownerName.nextLine();

    System.out.println("what is your ID?");
    Scanner ownerID = new Scanner(System.in);
    owner1.ID = ownerID.nextLine();

    System.out.println("what is your pet's name?");
    Scanner petName = new Scanner(System.in);

    System.out.println("How old are they?");
    System.out.println("for how long are they gonna stay with us?");
    System.out.println("Do they need any specialized care?");
    }
}
