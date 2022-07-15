/**
This is the NonAcademicCourse Class. This class is for the Non-Academic Courses. It contains instance variables and methods suitable for 
managing non-academic courses. This inherits from the main Course class .i.e. this is a child of Course class.
 */

public class NonAcademicCourse extends Course {
    private String instructorName, startingDate, completionDate, examDate, prerequisite;

    private boolean isRegistered, isRemoved;

    //constructor which takes 4 parameters
    public NonAcademicCourse(String courseId, String courseName, int duration, String prerequisite) {
        super(courseId, courseName, duration);
        this.prerequisite = prerequisite;

        //initializing variables to empty string
        instructorName = "";
        startingDate = "";
        completionDate = "";
        examDate = "";

        isRegistered = false;
        isRemoved = false;
    }

    // getter for instructorName instance variable
    public String getInstructorName() {
        return instructorName;
    }

    //setter for instructorName instance variable: sets only if the course is not registered yet.
    public void setInstructorName(String instructorName) {
        if (!isRegistered) {
            isRegistered = true;
            this.instructorName = instructorName;
        } else {
            System.out.println("Cannot set the Instructor Name. The course has already been registered");
        }
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

    // getter for examDate instance variable
    public String getExamDate() {
        return examDate;
    }

    //setter for examDate instance variable
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    // getter for prerequisite instance variable
    public String getPrerequisite() {
        return prerequisite;
    }

    //setter for prerequisite instance variable
    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    // getter for isRegistered instance variable
    public boolean getIsRegistered() {
        return isRegistered;
    }

    //setter for isRegistered instance variable
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    // getter and setter for isRemoved instance variable
    public boolean getIsRemoved() {
        return isRemoved;
    }

    //setter for isRemoved instance variable
    public void setIsRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    // method to register the course which takes 4 parameters: instructorName, startingDate, completionDate, examDate
    public void registerCourse(String courseLeader, String instructorName, String startingDate, String completionDate, String examDate) {
        if (isRegistered) {
            //show a message is course is already registered

            System.out.println("Sorry! The course is already registered");
            System.out.println("The registered course's instructor's name is " + instructorName
                + " and the course is starting at " + startingDate + ". The course is ending at " + completionDate);
        } else {

            //assign values to instance variables if not yet registered
            setCourseLeader(courseLeader);
            this.instructorName = instructorName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            this.examDate = examDate;
            isRegistered = true;
            isRemoved = false;

            //System.out.println("The non-academic course was registered successfully.");
        }
    }

    // method to remove the course which takes no parameter
    public void removeCourse() {
        if (isRemoved) {
            //cannot remove the course so show a message stating that
            System.out.println("The course is already removed or not yet registered.");
        } else {
            //reset all variables to default values for removing the course
            setCourseLeader("");
            instructorName = "";
            startingDate = "";
            completionDate = "";

            examDate = "";

            isRegistered = false;
            isRemoved = true;
            //System.out.println("The non-academic course was removed successfully!");
        }
    }

    // method to display the details of the course
    public void displayCourse() {
        //display the inherited variables using super's displayCourse method
        super.displayCourse();

        if (isRegistered) {
            //if it is registered then, show all details
            System.out.println("The instructor for this course is " + instructorName + ".");
            System.out
            .println("The course is beginning on " + startingDate + " and it ends on " + completionDate + ".");
            System.out.println("The course will have an exam on " + examDate + ".");
            System.out.println("The prerequisiste for this course is "+ prerequisite + ".");
        } else {
            //show appropriate message as course is not yet registered
            System.out.println("The course is not registered yet to show any details!");
        }
    }
}
