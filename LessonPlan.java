/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

import java.util.*;

public class LessonPlan{
    public String name;
    public ArrayList<Lesson> lessons = new ArrayList<>();
    public String subject;
    public String strand;
    public Coordinator coordinator;
    public Teacher teacher;

    public LessonPlan(String name, String subject, String strand, Coordinator coordinator){
        this.name = name;
        this.subject = subject;
        this.strand = strand;
        this.coordinator = coordinator;
    }

    public String getName (){
        return this.name;
    }

    public String getSubject (){
        return this.subject;
    }

    public String getTeacher (){
        return this.teacher.getName();
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }


    public void showDetails(){
        System.out.println("Lesson Plan Name: " + this.name);
        System.out.println("Subject: " + this.subject);
        System.out.println("Specialized for Strand: " + this.strand);
        System.out.println("Coordinator: " + (this.coordinator).getName());
        if (this.teacher != null){
            System.out.println("Teacher-in-charge: " + this.teacher.getName());
        }

    }

    public void showPlan(){
        System.out.println("List of Lessons in " + this.name + " Lesson Plan:");
        for (int i = 0; i < lessons.size(); i++){
            System.out.println("LESSON " + (i+1));
            lessons.get(i).showDetails();
        }
    }
}
