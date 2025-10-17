/*
Roque, Daryl John Clark
Marcelino, Princess Camille
Marimla, Chleo Jae
Gamboa, Rodel Vincent
CYB-201
 */

import java.io.*;
import java.util.*;

public class MainLessonPlan {
    public static Scanner input = new Scanner(System.in);

    public static final String PLAN_DIR = "C:\\Users\\Clark\\Downloads\\" + "Lesson Plan\\lessonplan_data\\";

    public static BufferedReader reader1 = null;
    public static BufferedReader reader2 = null;
    public static PrintWriter writer1;
    public static PrintWriter writer2;

    public static String[] strands = {"STEM", "ABM", "HUMSS", "TVL"};
    public static String[] subjects = {"English", "Filipino", "Livelihood", "Mathematics", "Science"};

    public static String[][] categories = {{"21st Century Literature", "Oral Communication", "Reading and Writing"},
                                            {"Komunikasyon", "Pagbasa", "Pananaliksik"},
                                            {"Entrepreneurship", "Home Economics", "ICT and Digital Skills"},
                                            {"General Mathematics", "Pre-Calculus", "Statistics and Probability"},
                                            {"Biology", "Earth and Life Science", "Physical Science"}};

    public static Coordinator coorSTEM = new Coordinator("Mr. Daryl John Clark Roque", 37, "STEM");
    public static Coordinator coorABM = new Coordinator("Ms. Princess Camille Marcelino", 27, "ABM");
    public static Coordinator coorHUMSS = new Coordinator("Mr. Chleo Jae Marimla", 30, "HUMSS");
    public static Coordinator coorTVL = new Coordinator("Mr. Rodel Vincent Gamboa", 32, "TVL");
    public static Coordinator[] coors = {coorSTEM, coorABM, coorHUMSS, coorTVL};
    public static String[] passwords = {"ST3MC00R", "A8M_C00R", "HUM55C00R", "TV7_C00R"};
    
    public static void main(String[] args){
        mainMenu();
    }

    public static void exitMenu() {
        boolean exitLoop = true;
        int choice = 0;

        do { 
            try {
                System.out.println("\nAre you sure you want to exit the program?");
                System.out.println("""
                        1 - Yes
                        2 - No""");
                System.out.print("Enter your choice (1-2): ");
                choice = Integer.parseInt(input.nextLine());
                if (choice == 1){
                    exitLoop = false;
                    System.out.println("Thank you for using our program!");
                    System.exit(0);
                }
                else if (choice == 2){
                    exitLoop = false;
                    mainMenu();
                }
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
        } while (exitLoop);
    }

    public static void mainMenu() {
    boolean menuLoop = true;
    int choice = 0;

        do { 
            try {
                menuLoop = true;
                System.out.println("\n=== LESSON PLANNER - SENIOR HIGH SCHOOL DEPARTMENT ===");
                System.out.println("Please select your strand location:");
                for (int i = 0; i < strands.length ; i++){
                    System.out.println((i+1) + " - " + strands[i]);
                }
                System.out.println("5 - Exit Program");
                System.out.print("Enter your choice (1-5): ");
                choice = Integer.parseInt(input.nextLine());
                if (choice == 5){
                    menuLoop = false;
                    exitMenu();
                }
                else if (choice <= 0 || choice >= 6){
                    throw new Exception();
                }
                choice -= 1;

                menuLoop = false;
                strandMenu(choice);
            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.\n");
            }
        } while (menuLoop);
    }

    public static void strandMenu(int stInd) {
        boolean strandLoop = true;
        int choice = 0;

        do { 
            try {
                strandLoop = true;
                System.out.println("\nYou have chosen the " + strands[stInd] + " strand!");
                System.out.println("Please select your role:");
                System.out.println("""
                1 - Coordinator
                2 - Teacher
                3 - Return to Main Menu""");
                System.out.print("Enter your choice (1-3): ");
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        strandLoop = false;
                        coorConfirm(stInd);
                        break;
                    case 2:
                        strandLoop = false;
                        subjectView("Teacher", stInd);
                        break;
                    case 3:
                        strandLoop = false;
                        mainMenu();
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
        } while (strandLoop);
    }

    public static void coorConfirm(int stInd){
    boolean cconfirmLoop = true;
    String password = "";

        do { 
            try {
                password= "";
                cconfirmLoop = true;
                System.out.println("\n" + strands[stInd] + " COORDINATOR LOGIN");
                System.out.print("Enter password (Enter \"0\" to exit): ");
                password = input.nextLine();
                if (password.equals("0")){
                    cconfirmLoop = false;
                    strandMenu(stInd);
                }
                else if (password.equals(passwords[stInd])){
                    cconfirmLoop = false;
                    coorMenu(stInd);
                }
                else {
                    throw new Exception();
                }
                
            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
    } while (cconfirmLoop);
}

    public static void coorMenu(int stInd){
        boolean coorLoop = true;
        int choice = 0;

        do { 
            try {
                coorLoop = true;
                System.out.println("\nWELCOME TO THE " + strands[stInd] + " COORDINATOR DASHBOARD!");
                System.out.println("This dashboard is for the " + strands[stInd] + " coordinator:");
                coors[stInd].showInfo();
                System.out.println("Choose your options:");
                System.out.println("""
                1 - View Subjects
                2 - View Teachers
                3 - Exit Dashboard""");
                System.out.print("Enter your choice (1-3): ");
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        coorLoop = false;
                        subjectView("Coordinator", stInd);
                        break;
                    case 2:
                        coorLoop = false;
                        teacherView(stInd);
                        break;
                    case 3:
                        coorLoop = false;
                        strandMenu(stInd);
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
    } while (coorLoop);
    }

    public static void teacherView(int stInd){
        String filepath2 = PLAN_DIR + strands[stInd] + "\\" + strands[stInd] + "_Teachers.csv";
        ArrayList<Teacher> teachers = new ArrayList<>();
        String line = "";

        try {
            reader2 = new BufferedReader(new FileReader(filepath2));
            reader2.readLine();
            while((line = reader2.readLine()) != null){
                String[] row = line.split(",");
                Teacher teacher = new Teacher(row[1], Integer.parseInt(row[2]), row[3]);
                teacher.setLessonPlan(row[0]);
                teachers.add(teacher);
        }
            reader2.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        for (int i = 0 ; i < teachers.size(); i++){
            System.out.println("TEACHER " + (i+1));
            teachers.get(i).showInfo();
        }
        boolean teachLoop = true;
        int choice = 0;
        do {
        try {
        System.out.println("\nChoose from the following:");
                    System.out.println("""
                    1 - Add Teacher
                    2 - Assign Teacher
                    3 - Remove Teacher
                    4 - Return to Coordinator Dashboard""");
                    System.out.print("Enter your choice (1-4): ");
                    choice = Integer.parseInt(input.nextLine());

                        switch (choice){
                            case 1:
                                teachLoop = false;
                                addTeach(stInd, teachers, filepath2);
                                break;
                            case 2:
                                teachLoop = false;
                                assignTeach(stInd, teachers, filepath2);
                                break;
                            case 3:
                                teachLoop = false;
                                delTeach(stInd, teachers, filepath2);
                                break;
                            case 4:
                                teachLoop = false;
                                coorMenu(stInd);
                                break;
                            default:
                                throw new Exception();
                        }
        } catch (Exception e) {
             System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
        }
        } while (teachLoop);
    }

    public static void assignTeach(int stInd, ArrayList<Teacher> teachers, String dirpath){
        boolean assignLoop = true;

        do { 
            try {
                assignLoop = true;
                System.out.println("\nAssign Teacher under the " + strands[stInd] + " strand");
                    for (int i = 0; i < teachers.size() ; i++){
                        System.out.println("TEACHER " + (i+1) +": " + teachers.get(i).getName());
                    }
                    System.out.print("Enter your choice (1-" + teachers.size() + ", enter \"0\" to exit): ");
                    int choice1 = Integer.parseInt(input.nextLine());
                    if (choice1 < 0 || choice1 > teachers.size()){
                        assignLoop = false;
                        throw new Exception();
                    }
                    else if (choice1 == 0){
                        assignLoop = false;
                        teacherView(stInd);
                    }
                    /*else if (!(teachers.get(choice1).getLessonPlan().equals("None"))){
                        assignLoop = false;
                        System.out.println("Teacher has already an assigned lesson plan.");
                        teacherView(stInd);
                    }*/
                    
                    choice1 -= 1;
                    System.out.println("Teacher has a subject major of " + teachers.get(choice1).getSubjectMajor());
                    int subInd = 0;
                    for (int b = 0; b < subjects.length ; b++){
                        if (subjects[b].equals(teachers.get(choice1).getSubjectMajor())){
                            subInd = b;
                        }
                    }
                    for (int i = 0; i < categories[subInd].length ; i++){
                        System.out.println((i+1) +" - " + categories[subInd][i]);
                    }
                    System.out.print("Enter your choice (1-" + categories[subInd].length + ", enter \"0\" to exit): ");
                    int choice2 = Integer.parseInt(input.nextLine());
                    if (choice2 < 0 || choice2 > teachers.size()){
                        assignLoop = false;
                        throw new Exception();
                    }
                    else if (choice2 == 0){
                        assignLoop = false;
                        teacherView(stInd);
                    }
                    choice2 -=1;

                    teachers.get(choice1).setLessonPlan(categories[subInd][choice2]);
                    teachers.get(choice1).showInfo();


                    System.out.println("""
                            \nDo you confirm this teacher's assignment?
                            1 - Yes
                            2 - No""");
                        System.out.print("Enter your choice (1-2): ");
                        int choice3 = Integer.parseInt(input.nextLine());
                        switch (choice3) {
                        case 1:
                            assignLoop = false;
                            reviseTeach(stInd, teachers, dirpath);
                            break;
                        case 2:
                            assignLoop = false;
                            teacherView(stInd);
                            break;
                        default:
                            assignLoop = false;
                            throw new Exception();
                    }
                    
            } catch (Exception e) {
                 System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
        } while (assignLoop);
    }

    public static void delTeach(int stInd, ArrayList<Teacher> teachers, String dirpath){
         boolean delLoop = true;
            
            do { 
                try {
                    delLoop = true;
                    System.out.println("\nRemove Teacher under the " + strands[stInd] + " strand");
                    for (int i = 0; i < teachers.size() ; i++){
                        System.out.println("TEACHER " + (i+1) +": " + teachers.get(i).getName());
                    }
                    System.out.print("Enter your choice (1-" + teachers.size() + ", enter \"0\" to exit): ");
                    int choice1 = Integer.parseInt(input.nextLine());
                    if (choice1 < 0 || choice1 > teachers.size()){
                        delLoop = false;
                        throw new Exception();
                    }
                    else if (choice1 == 0){
                        delLoop = false;
                        teacherView(stInd);
                    }
                    else {
                        choice1 -=1;
                        System.out.println();
                        teachers.get(choice1).showInfo();

                        System.out.println("""
                            \nDo you confirm to remove this teacher?
                            1 - Yes
                            2 - No""");
                        System.out.print("Enter your choice (1-2): ");
                        int choice2 = Integer.parseInt(input.nextLine());
                        switch (choice2) {
                        case 1:
                            delLoop = false;
                            teachers.remove(choice1);
                            reviseTeach(stInd, teachers, dirpath);
                            break;
                        case 2:
                            delLoop = false;
                            teacherView(stInd);
                            break;
                        default:
                            delLoop = false;
                            throw new Exception();
                    }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (delLoop);
    }

    public static void addTeach(int stInd, ArrayList<Teacher> teachers, String dirpath){
         boolean addLoop = true;
            
            do { 
                try {
                    addLoop = true;
                    System.out.println("\nAdd new Teacher under the " + strands[stInd] + " strand");
                    System.out.print("Teacher Name: ");
                    String name = input.nextLine();
                    System.out.print("Age: ");
                    int age = Integer.parseInt(input.nextLine());
                    System.out.print("""
                            Subject Major:
                            1 - English
                            2 - Filipino
                            3 - Livelihood
                            4 - Mathematics
                            5 - Science
                            """);
                    System.out.print("Enter your choice (1-5): ");
                    int subMajor = Integer.parseInt(input.nextLine());
                    subMajor -= 1;

                    Teacher teacher = new Teacher(name, age, subjects[subMajor]);
                    teacher.setLessonPlan("None");
                    teacher.showInfo();

                    System.out.println("""
                            \nDo you confirm your new teacher?
                            1 - Yes
                            2 - No""");
                    System.out.print("Enter your choice (1-2): ");
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            addLoop = false;
                            teachers.add(teacher);
                            reviseTeach(stInd, teachers, dirpath);
                            break;
                        case 2:
                            addLoop = false;
                            teacherView(stInd);
                            break;
                        default:
                            addLoop = false;
                            throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (addLoop);
    }


    public static void reviseTeach(int stInd, ArrayList<Teacher> teachers, String dirpath){
        try {
                writer2 = new PrintWriter(dirpath);
               
                writer2.println("Lesson Plan,Name,Age,Subject Major");
                
                for (int i = 0; i < teachers.size() ; i++){
                   writer2.println(teachers.get(i).getLessonPlan() + "," +
                                   teachers.get(i).getName() + "," +
                                   teachers.get(i).getAge() + "," +
                                   teachers.get(i).getSubjectMajor());
                }
                writer2.close();

                coorMenu(stInd);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    public static void subjectView(String role, int stInd){

    boolean subLoop = true;
    int choice = 0;
        do { 
            try {
                subLoop = true;
                System.out.println("\nChoose your subject:");
                for (int i = 0; i < subjects.length ; i++){
                    System.out.println((i+1) + " - " + subjects[i]);
                }
                System.out.println("6 - Return to Menu");
                System.out.print("Enter your choice (1-6): ");
                choice = Integer.parseInt(input.nextLine());
                choice -= 1;
                if (choice < 0 || choice > 5){
                        subLoop = false;
                        throw new Exception();
                }

                if (role.equals("Teacher")){
                    if (choice >= 0 && choice <= 4){
                        subLoop = false;
                        subMenu(role, stInd, choice);
                    }

                    else {
                        subLoop = false;
                        strandMenu(stInd);
                    }
                }
                else if (role.equals("Coordinator")){
                    if (choice >= 0 && choice <= 4){
                        subLoop = false;
                        subMenu(role, stInd, choice);
                    }

                    else {
                        subLoop = false;
                        coorMenu(stInd);
                    }
                }
            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
    } while (subLoop);
    }

    public static void subMenu(String role, int stInd, int subInd){
        String dirpath1 = PLAN_DIR + "\\" + strands[stInd] + "\\" + strands[stInd] + "_" + subjects[subInd];
        File directory = new File(dirpath1);

        System.out.println("\n== Categories for the " + subjects[subInd] + " subject in the " + strands[stInd] + " strand ==");
        File[] files = directory.listFiles();

        boolean subLoop = true;
        int choice = 0;

        do { 
            try {
                if (files != null ){
                    for (int i = 0 ; i < files.length ; i++) {
                        String catName = files[i].getName();
                        catName = catName.replace(strands[stInd] + "_", "");
                        catName = catName.replace("_Lessons", "");
                        catName = catName.replace(".csv", "");
                        System.out.println((i+1) + " - " + catName);
                    }
                }

                System.out.println((files.length + 1) + " - Return to Menu");
                System.out.print("Enter your choice (1-" + (files.length + 1) + "): ");
                choice = Integer.parseInt(input.nextLine());
                choice -= 1;

                if (choice < 0 || choice > files.length){
                        subLoop = false;
                        throw new Exception();
                }
                
                if (choice >= 0 || choice <= (files.length - 1)) {
                        subLoop = false;
                        if (choice == files.length) {
                            if (role.equals("Coordinator")){
                                subjectView("Coordinator", stInd);
                            }
                            else {
                                subjectView("Teacher", stInd);
                            }
                        }
                        String catName = files[choice].getName();
                        catName = catName.replace(strands[stInd] + "_", "");
                        catName = catName.replace("_Lessons", "");
                        catName = catName.replace(".csv", "");
                        catMenu(role, stInd, subInd, catName,dirpath1 + "\\" + files[choice].getName());
                }
                

            } catch (Exception e) {
                System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
            }
        } while (subLoop);
            
         
}

     public static void catMenu(String role, int stInd, int subInd, String catName, String filepath){
        LessonPlan lessonPlan = new LessonPlan(catName, subjects[subInd], strands[stInd], coors[stInd]);
        String line = "";

        try {
            String filepath2 = PLAN_DIR + strands[stInd] + "\\" + strands[stInd] + "_Teachers.csv";
            reader2 = new BufferedReader(new FileReader(filepath2));
            reader2.readLine();
            boolean readLoop = true;
            while (readLoop){
                 while((line = reader2.readLine()) != null){
                    String[] row = line.split(",");
                    if (row[0].equals(catName)){
                        Teacher teacher = new Teacher(row[1], Integer.parseInt(row[2]), row[3]);
                        lessonPlan.setTeacher(teacher);
                        readLoop = false;
                        reader2.close();
                    }
                }
                if (role.equals("Teacher")){
                    System.out.println("Sorry! You do not have access to this Lesson Plan!");
                    reader2.close();
                    readLoop = false;
                    subMenu(role, stInd, subInd);
            }
        }
        } catch (Exception e) {
            e.getStackTrace();
        }
            try {
                System.out.println("\n== Lessons for the " + catName + " category in the " + subjects[subInd] + " subject for the " + strands[stInd] + " strand ==");
                reader1 = new BufferedReader(new FileReader(filepath));
                reader1.readLine();
                while ((line = reader1.readLine()) != null){
                    String[] row = line.split(",");

                    Lesson lesson = new Lesson(row[0], row[1], row[2], Integer.parseInt(row[3]), row[4], row[5], row[6]);
                    lessonPlan.lessons.add(lesson);
                }
                reader1.close();

                lessonPlan.showDetails();
                lessonPlan.showPlan();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean catLoop = true;
            int choice = 0;

            do {
                try {
                    catLoop = true;
                    System.out.println("\nChoose from the following:");
                    System.out.println("""
                    1 - Add Lesson
                    2 - Delete Lesson
                    3 - Edit Lesson
                    4 - Return to Subject Menu""");
                    System.out.print("Enter your choice (1-4): ");
                    choice = Integer.parseInt(input.nextLine());

                        switch (choice){
                            case 1:
                                catLoop = false;
                                addLesson(role, stInd, subInd, catName, filepath, lessonPlan);
                                break;
                            case 2:
                                catLoop = false;
                                delLesson(role, stInd, subInd, catName, filepath, lessonPlan);
                                break;
                            case 3:
                                catLoop = false;
                                chooseEdit(role, stInd, subInd, catName, filepath, lessonPlan);
                                break;
                            case 4:
                                catLoop = false;
                                subMenu(role, stInd, subInd);
                                break;
                            default:
                                throw new Exception();
                        }
                    }
                 catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (catLoop);
        
        }

        public static void chooseEdit(String role, int stInd, int subInd, String catName, String filepath, LessonPlan lessonPlan){
            boolean chooseLoop = true;

            do { 
                try {
                    chooseLoop = true;
                    System.out.println("\nEdit lesson from " + catName + " - " + subjects[subInd] + " - " + strands[stInd]);
                    for (int i = 0; i < lessonPlan.lessons.size() ; i++){
                        System.out.println("LESSON " + (i+1) +": " + lessonPlan.lessons.get(i).getName());
                    }
                    System.out.print("Enter your choice (1-" + lessonPlan.lessons.size() + ", enter \"0\" to exit): ");
                    int choice1 = Integer.parseInt(input.nextLine());
                    if (choice1 < 0 || choice1 > lessonPlan.lessons.size()){
                        chooseLoop = false;
                        throw new Exception();
                    }
                    else if (choice1 == 0){
                        chooseLoop = false;
                        catMenu(role, stInd, subInd, catName, filepath);
                    }
                    else {
                        choice1 -=1;
                        System.out.println();
                        editLesson(role, stInd, subInd, catName, filepath, lessonPlan, choice1);
                    }
                } catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (chooseLoop);
        }

        public static void editLesson(String role, int stInd, int subInd, String catName, String filepath, LessonPlan lessonPlan, int lesInd){
            boolean editLoop = true;

            do { 
                try {
                    editLoop = true;
                    lessonPlan.lessons.get(lesInd).showDetails();
                    System.out.println("""
                            Choose which to edit:
                            1 - Lesson Name
                            2 - Lesson Description
                            3 - Lesson Hours
                            4 - Lesson Scheduling
                            5 - Lesson Requirement""");
                    System.out.print("Enter your choice (1-5): ");
                    int choice1 = Integer.parseInt(input.nextLine());
                    if (choice1 <= 0 || choice1 >= 6){
                        throw new Exception();
                    }

                    switch (choice1){
                        case 1:
                            System.out.print("Enter new lesson name: ");
                            String name = input.nextLine();
                            lessonPlan.lessons.get(lesInd).setName(name);
                            break;
                        case 2:
                            System.out.print("Enter lesson description: ");
                            String descri = input.nextLine();
                            lessonPlan.lessons.get(lesInd).setDescription(descri);
                            break;
                        case 3:
                            System.out.print("Enter new lesson hours: ");
                            int hours = Integer.parseInt(input.nextLine());
                            lessonPlan.lessons.get(lesInd).setHours(hours);
                            break;
                        case 4:
                            System.out.print("Enter week of lesson: ");
                            int week = Integer.parseInt(input.nextLine());
                            lessonPlan.lessons.get(lesInd).setSchedule("Week " + week);
                            break;
                        case 5:
                             System.out.print("Enter lesson requirement: ");
                            String req = input.nextLine();
                            lessonPlan.lessons.get(lesInd).setRequirement(req);
                            break;
                    }

                    lessonPlan.lessons.get(lesInd).showDetails();

                     System.out.println("""
                            \nDo you confirm to these changes?
                            1 - Yes
                            2 - No""");
                        System.out.print("Enter your choice (1-2): ");
                        int choice2 = Integer.parseInt(input.nextLine());
                        switch (choice2) {
                        case 1:
                            editLoop = false;
                            revisePlan(role, stInd, subInd, catName, filepath, lessonPlan);
                            break;
                        case 2:
                            editLoop = false;
                            catMenu(role, stInd, subInd, catName, filepath);
                            break;
                        default:
                            editLoop = false;
                            throw new Exception();
                    }

                } catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (editLoop);
        }

        public static void delLesson(String role, int stInd, int subInd, String catName, String filepath, LessonPlan lessonPlan) {
            boolean delLoop = true;
            
            do { 
                try {
                    delLoop = true;
                    System.out.println("\nDelete lesson from " + catName + " - " + subjects[subInd] + " - " + strands[stInd]);
                    for (int i = 0; i < lessonPlan.lessons.size() ; i++){
                        System.out.println("LESSON " + (i+1) +": " + lessonPlan.lessons.get(i).getName());
                    }
                    System.out.print("Enter your choice (1-" + lessonPlan.lessons.size() + ", enter \"0\" to exit): ");
                    int choice1 = Integer.parseInt(input.nextLine());
                    if (choice1 < 0 || choice1 > lessonPlan.lessons.size()){
                        delLoop = false;
                        throw new Exception();
                    }
                    else if (choice1 == 0){
                        delLoop = false;
                        catMenu(role, stInd, subInd, catName, filepath);
                    }
                    else {
                        choice1 -=1;
                        System.out.println();
                        lessonPlan.lessons.get(choice1).showDetails();

                         System.out.println("""
                            \nDo you confirm to delete this lesson?
                            1 - Yes
                            2 - No""");
                        System.out.print("Enter your choice (1-2): ");
                        int choice2 = Integer.parseInt(input.nextLine());
                        switch (choice2) {
                        case 1:
                            delLoop = false;
                            lessonPlan.lessons.remove(choice1);
                            revisePlan(role, stInd, subInd, catName, filepath, lessonPlan);
                            break;
                        case 2:
                            delLoop = false;
                            catMenu(role, stInd, subInd, catName, filepath);
                            break;
                        default:
                            delLoop = false;
                            throw new Exception();
                    }
                    }
                } catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (delLoop);
        }

        public static void addLesson(String role, int stInd, int subInd, String catName, String filepath, LessonPlan lessonPlan) {
            boolean addLoop = true;
            
            do { 
                try {
                    addLoop = true;
                    System.out.println("\nAdd new lesson to " + catName + " - " + subjects[subInd] + " - " + strands[stInd]);
                    System.out.print("Lesson Name: ");
                    String name = input.nextLine();
                    System.out.print("Description: ");
                    String descri = input.nextLine();
                    System.out.print("Lesson Hours: ");
                    int hours = Integer.parseInt(input.nextLine());
                    System.out.print("Scheduled Week: ");
                    int week = Integer.parseInt(input.nextLine());
                    System.out.print("Lesson Requirement: ");
                    String req = input.nextLine();

                    System.out.println();
                    Lesson lesson = new Lesson(name, subjects[subInd], descri, hours, strands[stInd], "Week " + week, req);
                    lesson.showDetails();

                    System.out.println("""
                            \nDo you confirm your new lesson?
                            1 - Yes
                            2 - No""");
                    System.out.print("Enter your choice (1-2): ");
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            addLoop = false;
                            lessonPlan.lessons.add(lesson);
                            revisePlan(role, stInd, subInd, catName, filepath, lessonPlan);
                            break;
                        case 2:
                            addLoop = false;
                            catMenu(role, stInd, subInd, catName, filepath);
                            break;
                        default:
                            addLoop = false;
                            throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Sorry! You have made a mistake in inputting! Please try again.");
                }
            } while (addLoop);
        }


        public static void revisePlan(String role, int stInd, int subInd, String catName, String filepath, LessonPlan lessonPlan){
            try {
                writer1 = new PrintWriter(filepath);
               
                writer1.println("Lesson,Subject,Description,Hours,Strand,Schedule,Requirement");
                
                for (int i = 0; i < lessonPlan.lessons.size() ; i++){
                    writer1.println(lessonPlan.lessons.get(i).getName() + "," +
                                   lessonPlan.lessons.get(i).getSubject() + "," +
                                   lessonPlan.lessons.get(i).getDescription() + "," +
                                   lessonPlan.lessons.get(i).getHours() + "," +
                                   lessonPlan.lessons.get(i).getStrand() + "," +
                                   lessonPlan.lessons.get(i).getSchedule() + "," +
                                   lessonPlan.lessons.get(i).getRequirement() + ",");
                }

                writer1.close();

                if (role.equals("Coordinator")){
                    coorMenu(stInd);
                }
                else if (role.equals("Teacher")){
                    subjectView(role, stInd);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }





