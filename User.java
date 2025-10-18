/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

public class User implements Show{
    protected String userName;
    protected int age;

    public User(String userName, int age){
        this.userName = userName;
        this.age = age;
    }

    public void showDetails(){
        System.out.println("\tName: " + this.userName);
        System.out.println("\tAge: " + age + " y/o");
    }

    public String getName(){
        return this.userName;
    }

    public int getAge(){
        return this.age;
    }
}
