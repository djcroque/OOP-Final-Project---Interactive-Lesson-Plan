/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

import java.util.*;

public class Coordinator extends User implements Show{
    public String strand;
    public ArrayList<Teacher> teachers = new ArrayList<>();

    public Coordinator(String userName, int age, String department){
        super(userName, age);
        this.strand = department;
    }

     public void showDetails(){
        super.showDetails();
        System.out.println("\tStrand: " + this.strand);
    }

    public String getStrand(){
        return this.strand;
    }

}
