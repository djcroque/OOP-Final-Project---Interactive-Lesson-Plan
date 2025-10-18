/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

public class Lesson implements Show{
    protected String name;
    protected String subject;
    protected String description;
    protected int hours;
    protected String strand;
    protected String schedule;
    protected String requirement;
    public Teacher teacher;

    public Lesson(String name, String subject, String description, int hours, String strand, String schedule, String requirement){
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.hours = hours;
        this.strand = strand;
        this.schedule = schedule;
        this.requirement = requirement;
    }

    public void showDetails(){
        System.out.println("\tLesson: " + this.name);
        System.out.println("\tDescription: " + this.description);
        System.out.println("\tLesson Hours: " + this.hours);
        System.out.println("\tScheduled Week/s: " + this.schedule);
        System.out.println("\tLesson Requirement: " + this.requirement);
    }

    public String getName(){
        return this.name;
    }

    public String getSubject(){
        return this.subject;
    }

    public String getDescription(){
        return this.description;
    }

    public int getHours(){
        return this.hours;
    }

    public String getStrand(){
        return this.strand;
    }
    
    public String getSchedule(){
        return this.schedule;
    }

    public String getRequirement(){
        return this.requirement;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public void setStrand(String strand){
        this.strand = strand;
    }
    
    public void setSchedule(String schedule){
        this.schedule = schedule;
    }

    public void setRequirement(String requirement){
        this.requirement = requirement;
    }

    public String getTeacher(){
        return this.teacher.getName();
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
