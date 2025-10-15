/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

import java.util.*;

public class Coordinator extends User {
    public String strand;
    public ArrayList<Teacher> teachers = new ArrayList<>();

    public Coordinator(String userName, int age, String department){
        super(userName, age);
        this.strand = department;
    }

     public void showInfo(){
        super.showInfo();
        System.out.println("\tStrand: " + this.strand);
    }

    public String getDepartment(){
        return this.strand;
    }

    /*public void assignTeacher(Teacher teacher, LessonPlan lessonPlan){
        if ((teacher.getSubjectMajor()).equals(lessonPlan.getSubject())){
            lessonPlan.setTeacher(teacher);
        }
        else {
            System.out.println("Teacher is not compatible with lesson.");
        }
    }*/

}
