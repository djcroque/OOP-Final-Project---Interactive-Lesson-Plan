/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

public class Teacher extends User {
    public String subjectMajor;
    public String lessonPlan;

    public Teacher(String userName, int age, String subjectMajor){
        super(userName, age);
        this.subjectMajor = subjectMajor;
    }

    public void showInfo(){
        super.showInfo();
        System.out.println("\tSubject Major: " + this.subjectMajor);
        if (this.lessonPlan != null){
            System.out.println("\tAssigned Lesson Plan: " + this.lessonPlan);
        }

    }

    public void setLessonPlan(String lessonPlan){
        this.lessonPlan = lessonPlan;
    }
    public String getLessonPlan(){
        return this.lessonPlan;
    }

    public void setSubjectMajor(String subjectMajor){
        this.subjectMajor = subjectMajor;
    }
    public String getSubjectMajor(){
        return this.subjectMajor;
    }
}
