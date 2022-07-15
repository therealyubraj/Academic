/**
This is the Course class. This is the parent class for other classes. This contains all base methods and instance variables that
others can inherit.
 */
public class Course {

    private String courseId, courseName, courseLeader;

    private int duration;

    //parametrized constructor which takes 4 paramters.
    public Course(String courseId, String courseName, int duration) {

        //assigning parameter's values to the respective variables
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;

        //setting the courseLeader to empty String
        this.courseLeader = "";
    }

    // getter for courseId instance variable
    public String getCourseId() {
        return courseId;
    }

    //setter for courseId instance variable
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    // getter for courseName instance variable
    public String getCourseName() {
        return courseName;
    }

    // setter for courseName instance variable
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // getter for courseLeader instance variable
    public String getCourseLeader() {
        return courseLeader;
    }
    // setter for courseLeader instance variable
    public void setCourseLeader(String courseLeader) {
        this.courseLeader = courseLeader;
    }

    // getter for duration instance variable
    public int getDuration() {
        return duration;
    }

    // setter for duration instance variable
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // method to display the details of the course
    public void displayCourse() {
        
        //display courseId, courseName and Duration of the course
        System.out.println("The Course Name of course ID " + courseId + " is " + courseName
            + " and the duration of the course is " + duration + ".");
        
            
            //display courseLeader only if it has been set to other than empty String.
        if (courseLeader != "") {
            System.out.println("The Course Leader for this course is " + courseLeader);
        }
    }
}
