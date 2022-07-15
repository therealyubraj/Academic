/**
This is the AcademicCourse Class. This class is for the Academic Courses. It contains instance variables and methods suitable for 
managing academic courses. This inherits from the main Course class .i.e. this is a child of Course class.
*/

public class AcademicCourse extends Course {
    private String lecturerName, startingDate, completionDate;

    private int noOfAssessments, level;
    
    private float credit;

    private boolean isRegistered;
    
    
    //parameterized constructor which takes 6 parameters
    public AcademicCourse(String courseId, String courseName, int duration, int level, float credit, int noOfAssessments) {
        super(courseId, courseName, duration);
        
        this.level = level;
        this.credit = credit;
        this.noOfAssessments = noOfAssessments;
    
        //initializing variables to empty string
        lecturerName = "";
        startingDate = "";
        completionDate = "";
        
        isRegistered = false;
    }

    // getter for lecturerName instance variable
    public String getLecturerName() {
        return lecturerName;
    }
    
    // setter for lecturerName instance variable
    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    // getter for level instance variable
    public int getLevel() {
        return level;
    }

    //setter for level instance variable
    public void setLevel(int level) {
        this.level = level;
    }

    // getter for credit instance variable
    public float getCredit() {
        return credit;
    }
    
    //setter for credit instance variable
    public void setCredit(float credit) {
        this.credit = credit;
    }

    // getter for startingDate instance variable
    public String getStartingDate() {
        return startingDate;
    }

    //setter for startingDate instance variable
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    // getter for completionDate instance variable
    public String getCompletionDate() {
        return completionDate;
    }

    //setter for completionDate instance variable
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    // getter for isRegistered instance variable
    public boolean getIsRegistered() {
        return isRegistered;
    }

    //setter for isRegistered instance variable
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    // getter for noOfAssessments instance variable
    public int getNoOfAssessments() {
        return noOfAssessments;
    }

    //setter for noOfAssessments instance variable
    public void setNoOfAssessments(int noOfAssessments) {
        this.noOfAssessments = noOfAssessments;
    }

    // method to register the course that take 4 parameters
    public void registerCourse(String courseLeader, String lecturerName, String startingDate, String completionDate) {
        if (!isRegistered) {
            //set value to instance variables is the course isn ot already registered!
            super.setCourseLeader(courseLeader);
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;

            this.isRegistered = true;
            
            //System.out.println("The academic course is registered successfully!");
        } else {
            System.out.println("Sorry! The course is already registered!! :(");
            System.out.println("The registered course's lecturer name is " + lecturerName
                + " and the course is starting at " + startingDate + ". The course is ending at " + completionDate);
        }
    }

    // method to display all the details about the course
    public void displayCourse() {
        //call parent's displayCourse() for displaying inherited variables
        super.displayCourse();
    
        if (isRegistered) {
            //show all details if course is registered
            System.out.println("The lecturer for this course is " + lecturerName + ".");
            System.out.println("The level of this course is " + level+ ".");
            System.out.println("The credit for this course is " + credit + " and there are " + noOfAssessments
                + " assignments in the course"+ ".");
            System.out.println("The course begins on " + startingDate + " and it ends on " + completionDate + ".");
        } else {
            //print a message if course is not yet registered!
            System.out.println("The course is not registered yet to show any details!");
        }
    }
}
