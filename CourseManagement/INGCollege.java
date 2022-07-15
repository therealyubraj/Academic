import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class INGCollege
    {
    //instance variables
        
    public JFrame mainFrame, addAcademicFrame, registerAcademicFrame, displayAcademicFrame, addNonAcademicFrame, registerNonAcademicFrame, removeNonAcademicFrame, displayNonAcademicFrame;
    public Font mainFont, headingFont; //main font for the GUI
    public Color backgroundColor; //backgroundColor for the GUI
    public ArrayList<Course> allCourses; //arraylist to store all courses

    INGCollege(){
        allCourses = new ArrayList<Course>();

        backgroundColor = new Color(58, 175, 169);
        
        try{
            //get font file from project directory
            File fontFile = new File(getClass().getResource("Comfortaa-Regular.ttf").getPath().replace("%20", " ")); //replace at the end as it is file URL, so spaces will be %20 and need to be replaced
            mainFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            mainFont = mainFont.deriveFont(Font.PLAIN,20);
            headingFont = mainFont.deriveFont(Font.BOLD,40);
        }catch(FontFormatException e){
            //font could not be loaded so load default one
            mainFont = new Font(Font.MONOSPACED, Font.PLAIN, 20);
            headingFont = new Font(Font.MONOSPACED, Font.BOLD, 40);
        }catch(IOException e){
            //font could not be loaded so load default one
            mainFont = new Font(Font.MONOSPACED, Font.PLAIN, 20);
            headingFont = new Font(Font.MONOSPACED, Font.BOLD, 40);
        }
        
        //construct all frames by using respective methods
        makeMainFrame();
        makeAddAcademicFrame();
        makeRegisterAcademicFrame();
        makeAddNonAcademicFrame();
        makeRegisterNonAcademicFrame();
        makeRemoveNonAcademicFrame();
        makeDisplayAcademicFrame();
        makeDisplayNonAcademicFrame();
        
        //set default close operations on all frames to avoid weird closing behaviours
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addNonAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerNonAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeNonAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayNonAcademicFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //show the mainFrame when the program starts
        mainFrame.setVisible(true);
    }
    
    
    //makes the GUI for main menu
    public void makeMainFrame(){
        mainFrame = new JFrame("Course Management");

        JPanel mainContainer = new JPanel();

        mainFrame.setSize(600, 600);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        mainContainer.setSize(600, 600);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        mainFrame.getContentPane().setBackground(backgroundColor);
        
        //defining all the GUI components for the main menu
        
        JLabel academicHeadingLabel = new JLabel("Academic Course");
        academicHeadingLabel.setFont(headingFont);
        academicHeadingLabel.setSize(academicHeadingLabel.getPreferredSize());
        academicHeadingLabel.setLocation(300 - academicHeadingLabel.getWidth()/2, 75);

        JButton addAcademicButton = new JButton("Add Academic Course");
        addAcademicButton.setSize(350, 35);
        addAcademicButton.setLocation(125, 155);
        addAcademicButton.setFont(mainFont);

        JButton registerAcademicButton = new JButton("Register Academic Course");
        registerAcademicButton.setSize(400, 35);
        registerAcademicButton.setLocation(100, 200);
        registerAcademicButton.setFont(mainFont);

        JButton displayAcademicButton = new JButton("Display Academic Course");
        displayAcademicButton.setSize(350, 35);
        displayAcademicButton.setLocation(125, 245);
        displayAcademicButton.setFont(mainFont);
        
        
        //a horizontal line to separate two courses
        JSeparator hr = new JSeparator();
        hr.setBounds(0, 300, 600, 10);

        JLabel nonAcademicHeadingLabel = new JLabel("Non-Academic Course");
        nonAcademicHeadingLabel.setFont(headingFont);
        nonAcademicHeadingLabel.setSize(nonAcademicHeadingLabel.getPreferredSize());
        nonAcademicHeadingLabel.setLocation(300 - nonAcademicHeadingLabel.getWidth()/2, 325);

        JButton addNonAcademicButton = new JButton("Add NonAcademic Course");
        addNonAcademicButton.setSize(350, 35);
        addNonAcademicButton.setLocation(125, 380);
        addNonAcademicButton.setFont(mainFont);

        JButton registerNonAcademicButton = new JButton("Register NonAcademic Course");
        registerNonAcademicButton.setSize(400, 35);
        registerNonAcademicButton.setLocation(100, 425);
        registerNonAcademicButton.setFont(mainFont);

        JButton removeNonAcademicButton = new JButton("Remove NonAcademic Course");
        removeNonAcademicButton.setSize(350, 35);
        removeNonAcademicButton.setLocation(125, 470);
        removeNonAcademicButton.setFont(mainFont);

        JButton displayNonAcademicButton = new JButton("Display NonAcademic Course");
        displayNonAcademicButton.setSize(350, 35);
        displayNonAcademicButton.setLocation(125, 515);
        displayNonAcademicButton.setFont(mainFont);

        //**** Action listeners here using anonymous class****
        addAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the addAcademicFrame
                    mainFrame.setVisible(false);
                    addAcademicFrame.setVisible(true);
                }
            });

        registerAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the registerAcademicFrame
                    makeRegisterAcademicFrame(); //do this to update the combobox for courseId
                    mainFrame.setVisible(false);
                    registerAcademicFrame.setVisible(true);
                }
            });

        displayAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the displayAcademicFrame
                    makeDisplayAcademicFrame();//do this to update the combobox for courseId
                    mainFrame.setVisible(false);
                    displayAcademicFrame.setVisible(true);
                }
            });

        addNonAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the addNonAcademicFrame
                    mainFrame.setVisible(false);
                    addNonAcademicFrame.setVisible(true);
                }
            });

        registerNonAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the registerNonAcademicFrame
                    makeRegisterNonAcademicFrame(); //do this to update the combobox for courseId
                    mainFrame.setVisible(false);
                    registerNonAcademicFrame.setVisible(true);
                }
            });

        removeNonAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the removeNonAcademicFrame
                    makeRemoveNonAcademicFrame();//do this to update the combobox for courseId
                    mainFrame.setVisible(false);
                    removeNonAcademicFrame.setVisible(true);
                }
            });
        displayNonAcademicButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //hide this frame and show the removeNonAcademicFrame
                    makeDisplayNonAcademicFrame();//do this to update the combobox for courseId
                    mainFrame.setVisible(false);
                    displayNonAcademicFrame.setVisible(true);
                }
            });
        
        //add all the components to the JPanel
        mainContainer.add(academicHeadingLabel);
        mainContainer.add(addAcademicButton);
        mainContainer.add(registerAcademicButton);
        mainContainer.add(displayAcademicButton);
        mainContainer.add(hr);
        mainContainer.add(nonAcademicHeadingLabel);
        mainContainer.add(addNonAcademicButton);
        mainContainer.add(registerNonAcademicButton);
        mainContainer.add(removeNonAcademicButton);
        mainContainer.add(displayNonAcademicButton);
        
        //add the JPanel to the JFrame
        mainFrame.add(mainContainer);
    }

    public void makeAddAcademicFrame(){
        addAcademicFrame = new JFrame("Add Academic Course");

        JPanel mainContainer = new JPanel();

        addAcademicFrame.setSize(900, 500);
        addAcademicFrame.setResizable(false);
        addAcademicFrame.setLayout(null);

        mainContainer.setSize(900, 500);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        addAcademicFrame.getContentPane().setBackground(backgroundColor);
        
        //making the GUI components for add academic course frame
        
        JLabel courseIdLabel = new JLabel("Course ID: ");
        courseIdLabel.setFont(mainFont);
        courseIdLabel.setForeground(Color.BLACK);
        courseIdLabel.setSize(courseIdLabel.getPreferredSize());
        courseIdLabel.setLocation(50, 80);

        JTextField courseIdField = new JTextField();
        courseIdField.setForeground(Color.WHITE);
        courseIdField.setOpaque(false);
        courseIdField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        courseIdField.setFont(mainFont);
        courseIdField.setSize(175, 30);
        courseIdField.setLocation(190, 80);

        JLabel courseNameLabel = new JLabel("Course Name: ");
        courseNameLabel.setFont(mainFont);
        courseNameLabel.setSize(courseNameLabel.getPreferredSize());
        courseNameLabel.setLocation(450, 80);

        JTextField courseNameField = new JTextField();
        courseNameField.setForeground(Color.WHITE);
        courseNameField.setOpaque(false);
        courseNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        courseNameField.setFont(mainFont);
        courseNameField.setSize(175, 30);
        courseNameField.setLocation(620, 80);

        JLabel durationLabel = new JLabel("Duration: ");
        durationLabel.setFont(mainFont);
        durationLabel.setForeground(Color.BLACK);
        durationLabel.setSize(durationLabel.getPreferredSize());
        durationLabel.setLocation(63, 180);

        JTextField durationField = new JTextField();
        durationField.setForeground(Color.WHITE);
        durationField.setOpaque(false);
        durationField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        durationField.setFont(mainFont);
        durationField.setSize(175, 30);
        durationField.setLocation(190, 180);

        JLabel levelLabel = new JLabel("Level: ");
        levelLabel.setFont(mainFont);
        levelLabel.setSize(levelLabel.getPreferredSize());
        levelLabel.setLocation(523, 180);

        JTextField levelField = new JTextField();
        levelField.setForeground(Color.WHITE);
        levelField.setOpaque(false);
        levelField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        levelField.setFont(mainFont);
        levelField.setSize(175, 30);
        levelField.setLocation(620, 180);

        JLabel creditLabel = new JLabel("Credit: ");
        creditLabel.setFont(mainFont);
        creditLabel.setForeground(Color.BLACK);
        creditLabel.setSize(creditLabel.getPreferredSize());
        creditLabel.setLocation(85, 280);

        JTextField creditField = new JTextField();
        creditField.setForeground(Color.WHITE);
        creditField.setOpaque(false);
        creditField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        creditField.setFont(mainFont);
        creditField.setSize(175, 30);
        creditField.setLocation(190, 280);

        JLabel noOfAssessmentsLabel1 = new JLabel("Number");
        noOfAssessmentsLabel1.setFont(mainFont);
        noOfAssessmentsLabel1.setSize(noOfAssessmentsLabel1.getPreferredSize());
        noOfAssessmentsLabel1.setLocation(475, 255);

        JLabel noOfAssessmentsLabel2 = new JLabel("of Assessments:");
        noOfAssessmentsLabel2.setFont(mainFont);
        noOfAssessmentsLabel2.setSize(noOfAssessmentsLabel2.getPreferredSize());
        noOfAssessmentsLabel2.setLocation(420, 285);

        JTextField noOfAssessmentsField = new JTextField();
        noOfAssessmentsField.setForeground(Color.WHITE);
        noOfAssessmentsField.setOpaque(false);
        noOfAssessmentsField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        noOfAssessmentsField.setFont(mainFont);
        noOfAssessmentsField.setSize(175, 30);
        noOfAssessmentsField.setLocation(620, 280);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        JButton addButton = new JButton("Add");
        addButton.setSize(125, 30);
        addButton.setLocation(670, 400);
        addButton.setFont(mainFont);

        JButton clearButton = new JButton("Clear");
        clearButton.setSize(125, 30);
        clearButton.setLocation(538, 400);
        clearButton.setFont(mainFont);

        //**** Action listeners here using anonymous class****

        addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = courseIdField.getText();
                    String courseName = courseNameField.getText();

                    int duration, noOfAssessments,level;
                    float credit;

                    if(courseId.equals("") || courseName.equals("")){
                        //empty field check
                        JOptionPane.showMessageDialog(addAcademicFrame,
                            "Please dont leave any fields empty!",
                            "Empty Field Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    //invalid value for duration check
                    try{
                        duration = Integer.parseInt(durationField.getText());
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(addAcademicFrame,
                            "Please Enter a valid integer for duration. \n \"" + durationField.getText() + "\" is not a valid number!!",
                            "Illegal Number Error",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    //invalid value for noOfAssessments check
                    try{
                        noOfAssessments = Integer.parseInt(noOfAssessmentsField.getText());
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(addAcademicFrame,
                            "Please Enter a valid integer for Number of Assessments. \n \"" + noOfAssessmentsField.getText() + "\" is not a valid number!!",
                            "Illegal Number Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    //invalid value for level check
                    try{
                        level = Integer.parseInt(levelField.getText());
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(addAcademicFrame,
                            "Please Enter a valid integer for Level. \n \"" + levelField.getText() + "\" is not a valid number!!",
                            "Illegal Number Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                        
                    //invalid value for credit check
                    try{
                        credit = Float.parseFloat(creditField.getText());
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(addAcademicFrame,
                            "Please Enter a valid value for Credit. \n \"" + creditField.getText() + "\" is not a valid value!!",
                            "Illegal Number Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    boolean isNewCourse = true; //this boolean is true only if the current courseId doesnot exist in the list allCourses
                    for(Course c : allCourses){
                        if(c.getCourseId().equals(courseId)){
                            isNewCourse = false; //set to false if found
                            break;
                        }
                    }

                    if(isNewCourse){
                        //is a valid courseId
                        Course ac = new AcademicCourse(courseId, courseName, duration, level, credit, noOfAssessments);
                        allCourses.add(ac);
                        
                        //clear all textfields
                        courseIdField.setText("");
                        courseNameField.setText("");
                        durationField.setText("");
                        levelField.setText("");
                        creditField.setText("");
                        noOfAssessmentsField.setText("");
                        
                        //show the dialog box
                        JOptionPane.showMessageDialog(addAcademicFrame,"Successfully Added.","Alert",JOptionPane.WARNING_MESSAGE); 
                        
                        //hide this frame and go to main menu
                        mainFrame.setVisible(true);
                        addAcademicFrame.setVisible(false);
                    }else{
                        //is duplicate courseId
                        JOptionPane.showMessageDialog(addAcademicFrame,
                            "A course with the same courseId " + courseId + " has already been added!",
                            "Duplication error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //clear all fields
                    courseIdField.setText("");
                    courseNameField.setText("");
                    durationField.setText("");
                    levelField.setText("");
                    creditField.setText("");
                    noOfAssessmentsField.setText("");
                    
                    //goto main menu
                    mainFrame.setVisible(true);
                    addAcademicFrame.setVisible(false);
                }
            });

        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //clear all textfields
                    courseIdField.setText("");
                    courseNameField.setText("");
                    durationField.setText("");
                    levelField.setText("");
                    creditField.setText("");
                    noOfAssessmentsField.setText("");
                }
            });
        
        //add all the GUI components to the JPanel
        mainContainer.add(courseIdLabel);
        mainContainer.add(courseIdField);
        mainContainer.add(courseNameLabel);
        mainContainer.add(courseNameField);
        mainContainer.add(durationLabel);
        mainContainer.add(durationField);
        mainContainer.add(levelLabel);
        mainContainer.add(levelField);
        mainContainer.add(creditLabel);
        mainContainer.add(creditField);
        mainContainer.add(noOfAssessmentsLabel1);
        mainContainer.add(noOfAssessmentsLabel2);
        mainContainer.add(noOfAssessmentsField);
        mainContainer.add(addButton);
        mainContainer.add(clearButton);
        mainContainer.add(backButton);
        
        //add mainContainer to JFrame
        addAcademicFrame.add(mainContainer);
    }

    public void makeRegisterAcademicFrame(){
        registerAcademicFrame = new JFrame("Register Academic Course");

        JPanel mainContainer = new JPanel();

        registerAcademicFrame.setSize(1000, 530);
        registerAcademicFrame.setResizable(false);
        registerAcademicFrame.setLayout(null);

        mainContainer.setSize(1000, 530);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        registerAcademicFrame.getContentPane().setBackground(backgroundColor);
        
        //make GUI components for registration
        JLabel courseIdLabel = new JLabel("Course ID: ");
        courseIdLabel.setFont(mainFont);
        courseIdLabel.setForeground(Color.BLACK);
        courseIdLabel.setSize(courseIdLabel.getPreferredSize());
        courseIdLabel.setLocation(92, 110);

        JComboBox<Object> courseIdBox = new JComboBox<Object>(getUnregisteredAcademicCourses());
        courseIdBox.setFont(mainFont);
        courseIdBox.setSize(175, 30);
        courseIdBox.setLocation(230, 110);

        JLabel courseLeaderLabel = new JLabel("Course Leader: ");
        courseLeaderLabel.setFont(mainFont);
        courseLeaderLabel.setForeground(Color.BLACK);
        courseLeaderLabel.setSize(courseLeaderLabel.getPreferredSize());
        courseLeaderLabel.setLocation(40, 180);

        JTextField courseLeaderField = new JTextField();
        courseLeaderField.setForeground(Color.WHITE);
        courseLeaderField.setOpaque(false);
        courseLeaderField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        courseLeaderField.setFont(mainFont);
        courseLeaderField.setSize(175, 30);
        courseLeaderField.setLocation(230, 180);

        JLabel startingDateLabel = new JLabel("Starting Date: ");
        startingDateLabel.setFont(mainFont);
        startingDateLabel.setSize(startingDateLabel.getPreferredSize());
        startingDateLabel.setLocation(490, 180);

        String[] startingDateYearItems = {"2021", "2022", "2023", "2024", "2025", "2026"};
        JComboBox<Object> startingDateYearBox = new JComboBox<Object>(startingDateYearItems);
        startingDateYearBox.setFont(mainFont);
        startingDateYearBox.setSize(startingDateYearBox.getPreferredSize());
        startingDateYearBox.setLocation(640, 180);

        String[] startingDateMonthItems = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
        JComboBox<Object> startingDateMonthBox = new JComboBox<Object>(startingDateMonthItems);
        startingDateMonthBox.setFont(mainFont);
        startingDateMonthBox.setSize(startingDateMonthBox.getPreferredSize());
        startingDateMonthBox.setLocation(720, 180);
        
        String[] startingDateDayItems = new String[32];
        for(int i = 0;i < startingDateDayItems.length;i++){
            startingDateDayItems[i] = (i + 1) + ""; //i + 1 as indices start from 0
        }
        JComboBox<Object> startingDateDayBox = new JComboBox<Object>(startingDateDayItems);
        startingDateDayBox.setFont(mainFont);
        startingDateDayBox.setSize(startingDateDayBox.getPreferredSize());
        startingDateDayBox.setLocation(865, 180);

        JLabel lecturerNameLabel = new JLabel("Lecturer Name: ");
        lecturerNameLabel.setFont(mainFont);
        lecturerNameLabel.setForeground(Color.BLACK);
        lecturerNameLabel.setSize(lecturerNameLabel.getPreferredSize());
        lecturerNameLabel.setLocation(40, 280);

        JTextField lecturerNameField = new JTextField();
        lecturerNameField.setForeground(Color.WHITE);
        lecturerNameField.setOpaque(false);
        lecturerNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        lecturerNameField.setFont(mainFont);
        lecturerNameField.setSize(175, 30);
        lecturerNameField.setLocation(230, 280);

        JLabel completionDateLabel = new JLabel("Completion Date: ");
        completionDateLabel.setFont(mainFont);
        completionDateLabel.setSize(completionDateLabel.getPreferredSize());
        completionDateLabel.setLocation(455, 280);

        String[] completionDateYearItems = {"2021", "2022", "2023", "2024", "2025", "2026"};
        JComboBox<Object> completionDateYearBox = new JComboBox<Object>(completionDateYearItems);
        completionDateYearBox.setFont(mainFont);
        completionDateYearBox.setSize(completionDateYearBox.getPreferredSize());
        completionDateYearBox.setLocation(640, 280);

        String[] completionDateMonthItems = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
        JComboBox<Object> completionDateMonthBox = new JComboBox<Object>(completionDateMonthItems);
        completionDateMonthBox.setFont(mainFont);
        completionDateMonthBox.setSize(completionDateMonthBox.getPreferredSize());
        completionDateMonthBox.setLocation(720, 280);

        String[] completionDateDayItems = new String[32];
        for(int i = 0;i < completionDateDayItems.length;i++){
            completionDateDayItems[i] = (i + 1) + "";
        }
        JComboBox<Object> completionDateDayBox = new JComboBox<Object>(completionDateDayItems);
        completionDateDayBox.setFont(mainFont);
        completionDateDayBox.setSize(completionDateDayBox.getPreferredSize());
        completionDateDayBox.setLocation(865, 280);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        JButton registerButton = new JButton("Register");
        registerButton.setSize(125, 30);
        registerButton.setLocation(800, 400);
        registerButton.setFont(mainFont);

        JButton clearButton = new JButton("Clear");
        clearButton.setSize(125, 30);
        clearButton.setLocation(670, 400);
        clearButton.setFont(mainFont);

        //**** Action listeners here using anonymous class****
        registerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = (String) courseIdBox.getSelectedItem();

                    String courseLeader = courseLeaderField.getText();
                    String lecturerName = lecturerNameField.getText();

                    String startingDateYear = (String) startingDateYearBox.getSelectedItem();
                    String startingDateMonth = (String) startingDateMonthBox.getSelectedItem();
                    String startingDateDay = (String) startingDateDayBox.getSelectedItem();

                    String completionDateYear = (String) completionDateYearBox.getSelectedItem();
                    String completionDateMonth = (String) completionDateMonthBox.getSelectedItem();
                    String completionDateDay = (String) completionDateDayBox.getSelectedItem();

                    String startingDate = startingDateYear + "-" + startingDateMonth + "-" + startingDateDay;
                    String completionDate = completionDateYear + "-" + completionDateMonth + "-" + completionDateDay;

                    String startingMonthToInt = startingDateMonthBox.getSelectedIndex() + 1 + ""; //since indices start at 0 add 1 for actual month
                    String completionMonthToInt = completionDateMonthBox.getSelectedIndex() + 1 + ""; //since indices start at 0 add 1 for actual month

                    if(courseId == null){
                        JOptionPane.showMessageDialog(registerAcademicFrame,
                            "No courses have been added to register yet!! Please add an academic course before registering!!",
                            "CourseList Empty Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    if(!isFirstDateSmall(startingDateYear, startingMonthToInt, startingDateDay, completionDateYear, completionMonthToInt, completionDateDay)){
                        JOptionPane.showMessageDialog(registerAcademicFrame,
                            "Dates are not properly input. Starting Date must come before the Completion Date.",
                            "Date Order Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    if(courseLeader.equals("") || lecturerName.equals("")){
                        JOptionPane.showMessageDialog(registerAcademicFrame,
                            "Please dont leave any fields empty!",
                            "Empty Field Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    for(Course c : allCourses){
                        if(c instanceof AcademicCourse){
                            AcademicCourse ac = (AcademicCourse) c;
                            if(ac.getCourseId().equals(courseId)){
                                //found the course with the courseId
                                ac.registerCourse(courseLeader, lecturerName, startingDate, completionDate); 

                                JOptionPane.showMessageDialog(registerAcademicFrame,"Successfully Registered.","Alert",JOptionPane.WARNING_MESSAGE); 
                                
                                //go back to main menu
                                mainFrame.setVisible(true);
                                registerAcademicFrame.setVisible(false);
                                break;
                            }
                        }
                    }

                }
            });

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courseLeaderField.setText("");
                    lecturerNameField.setText("");

                    mainFrame.setVisible(true);
                    registerAcademicFrame.setVisible(false);
                }
            });

        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courseLeaderField.setText("");
                    lecturerNameField.setText("");
                }
            });

        mainContainer.add(courseIdLabel);
        mainContainer.add(courseIdBox);
        mainContainer.add(courseLeaderLabel);
        mainContainer.add(courseLeaderField);
        mainContainer.add(startingDateLabel);
        mainContainer.add(startingDateYearBox);
        mainContainer.add(startingDateMonthBox);
        mainContainer.add(startingDateDayBox);
        mainContainer.add(completionDateLabel);
        mainContainer.add(completionDateYearBox);
        mainContainer.add(completionDateMonthBox);
        mainContainer.add(completionDateDayBox);
        mainContainer.add(lecturerNameLabel);
        mainContainer.add(lecturerNameField);
        mainContainer.add(registerButton);
        mainContainer.add(clearButton);
        mainContainer.add(backButton);

        registerAcademicFrame.add(mainContainer);
    }

    public void makeAddNonAcademicFrame(){
        addNonAcademicFrame = new JFrame("Add Non-Academic Course");

        JPanel mainContainer = new JPanel();

        addNonAcademicFrame.setSize(900, 400);
        addNonAcademicFrame.setResizable(false);
        addNonAcademicFrame.setLayout(null);

        mainContainer.setSize(900, 400);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        addNonAcademicFrame.getContentPane().setBackground(backgroundColor);
        
        //make GUI components for this frame
        JLabel courseIdLabel = new JLabel("Course ID: ");
        courseIdLabel.setFont(mainFont);
        courseIdLabel.setForeground(Color.BLACK);
        courseIdLabel.setSize(courseIdLabel.getPreferredSize());
        courseIdLabel.setLocation(50, 120);

        JTextField courseIdField = new JTextField();
        courseIdField.setForeground(Color.WHITE);
        courseIdField.setOpaque(false);
        courseIdField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        courseIdField.setFont(mainFont);
        courseIdField.setSize(175, 30);
        courseIdField.setLocation(190, 120);

        JLabel courseNameLabel = new JLabel("Course Name: ");
        courseNameLabel.setFont(mainFont);
        courseNameLabel.setSize(courseNameLabel.getPreferredSize());
        courseNameLabel.setLocation(450, 120);

        JTextField courseNameField = new JTextField();
        courseNameField.setForeground(Color.WHITE);
        courseNameField.setOpaque(false);
        courseNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        courseNameField.setFont(mainFont);
        courseNameField.setSize(175, 30);
        courseNameField.setLocation(620, 120);

        JLabel durationLabel = new JLabel("Duration: ");
        durationLabel.setFont(mainFont);
        durationLabel.setForeground(Color.BLACK);
        durationLabel.setSize(durationLabel.getPreferredSize());
        durationLabel.setLocation(63, 220);

        JTextField durationField = new JTextField();
        durationField.setForeground(Color.WHITE);
        durationField.setOpaque(false);
        durationField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        durationField.setFont(mainFont);
        durationField.setSize(175, 30);
        durationField.setLocation(190, 220);

        JLabel prerequisiteLabel = new JLabel("Prerequisite: ");
        prerequisiteLabel.setFont(mainFont);
        prerequisiteLabel.setSize(prerequisiteLabel.getPreferredSize());
        prerequisiteLabel.setLocation(468, 220);

        JTextField prerequisiteField = new JTextField();
        prerequisiteField.setForeground(Color.WHITE);
        prerequisiteField.setOpaque(false);
        prerequisiteField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        prerequisiteField.setFont(mainFont);
        prerequisiteField.setSize(175, 30);
        prerequisiteField.setLocation(620, 220);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        JButton addButton = new JButton("Add");
        addButton.setSize(125, 30);
        addButton.setLocation(670, 300);
        addButton.setFont(mainFont);

        JButton clearButton = new JButton("Clear");
        clearButton.setSize(125, 30);
        clearButton.setLocation(538, 300);
        clearButton.setFont(mainFont);

        //**** Action listeners here using anonymous class****

        addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = courseIdField.getText();
                    String courseName = courseNameField.getText();
                    String prerequisite = prerequisiteField.getText();    
                    int duration;
                    
                    if(courseId.equals("") || courseName.equals("") || prerequisite.equals("")){
                        JOptionPane.showMessageDialog(addNonAcademicFrame,
                            "Please dont leave any fields empty!",
                            "Empty Field Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    //non-integer input for duration
                    try{
                        duration = Integer.parseInt(durationField.getText());
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(addNonAcademicFrame,
                            "Please Enter a valid integer for duration. \n \"" + durationField.getText() + "\" is not a valid number!!",
                            "Illegal Number Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    boolean isNewCourse = true; //this boolean is true only if this courseId is new
                    for(Course c : allCourses){
                        if(c.getCourseId().equals(courseId)){
                            isNewCourse = false; 
                            break;
                        }
                    }

                    if(isNewCourse){
                        //add to the list
                        Course nac = new NonAcademicCourse(courseId, courseName, duration, prerequisite);
                        allCourses.add(nac);

                        courseIdField.setText("");
                        courseNameField.setText("");
                        durationField.setText("");
                        prerequisiteField.setText("");

                        JOptionPane.showMessageDialog(addNonAcademicFrame,"Successfully Added.","Alert",JOptionPane.WARNING_MESSAGE); 
                        
                        //go to main menu
                        mainFrame.setVisible(true);
                        addNonAcademicFrame.setVisible(false);
                    }else{
                        //show error
                        JOptionPane.showMessageDialog(addNonAcademicFrame,
                            "A course with the same courseId " + courseId + " has already been added!",
                            "Duplication error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courseIdField.setText("");
                    courseNameField.setText("");
                    durationField.setText("");
                    prerequisiteField.setText("");

                    mainFrame.setVisible(true);
                    addNonAcademicFrame.setVisible(false);
                }
            });

        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courseIdField.setText("");
                    courseNameField.setText("");
                    durationField.setText("");
                    prerequisiteField.setText("");
                }
            });
        
        //add all components to JPanel
        mainContainer.add(courseIdLabel);
        mainContainer.add(courseIdField);
        mainContainer.add(courseNameLabel);
        mainContainer.add(courseNameField);
        mainContainer.add(durationLabel);
        mainContainer.add(durationField);
        mainContainer.add(prerequisiteLabel);
        mainContainer.add(prerequisiteField);
        mainContainer.add(addButton);
        mainContainer.add(clearButton);
        mainContainer.add(backButton);
        
        //add mainContainer to frame
        addNonAcademicFrame.add(mainContainer);
    }

    public void makeRegisterNonAcademicFrame(){
        registerNonAcademicFrame = new JFrame("Register Non-Academic Course");

        JPanel mainContainer = new JPanel();

        registerNonAcademicFrame.setSize(1000, 530);
        registerNonAcademicFrame.setResizable(false);
        registerNonAcademicFrame.setLayout(null);

        mainContainer.setSize(1000, 530);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        registerNonAcademicFrame.getContentPane().setBackground(backgroundColor);
        
        //make all GUI components for this frame
        JLabel courseIdLabel = new JLabel("Course ID: ");
        courseIdLabel.setFont(mainFont);
        courseIdLabel.setForeground(Color.BLACK);
        courseIdLabel.setSize(courseIdLabel.getPreferredSize());
        courseIdLabel.setLocation(92, 110);

        JComboBox<Object> courseIdBox = new JComboBox<Object>(getUnregisteredNonAcademicCourses());
        courseIdBox.setFont(mainFont);
        courseIdBox.setSize(175, 30);
        courseIdBox.setLocation(230, 110);

        JLabel courseLeaderLabel = new JLabel("Course Leader: ");
        courseLeaderLabel.setFont(mainFont);
        courseLeaderLabel.setForeground(Color.BLACK);
        courseLeaderLabel.setSize(courseLeaderLabel.getPreferredSize());
        courseLeaderLabel.setLocation(40, 195);

        JTextField courseLeaderField = new JTextField();
        courseLeaderField.setForeground(Color.WHITE);
        courseLeaderField.setOpaque(false);
        courseLeaderField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        courseLeaderField.setFont(mainFont);
        courseLeaderField.setSize(175, 30);
        courseLeaderField.setLocation(230, 195);

        JLabel startingDateLabel = new JLabel("Starting Date: ");
        startingDateLabel.setFont(mainFont);
        startingDateLabel.setSize(startingDateLabel.getPreferredSize());
        startingDateLabel.setLocation(490, 110);

        String[] startingDateYearItems = {"2021", "2022", "2023", "2024", "2025", "2026"};
        JComboBox<Object> startingDateYearBox = new JComboBox<Object>(startingDateYearItems);
        startingDateYearBox.setFont(mainFont);
        startingDateYearBox.setSize(startingDateYearBox.getPreferredSize());
        startingDateYearBox.setLocation(640, 110);

        String[] startingDateMonthItems = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
        JComboBox<Object> startingDateMonthBox = new JComboBox<Object>(startingDateMonthItems);
        startingDateMonthBox.setFont(mainFont);
        startingDateMonthBox.setSize(startingDateMonthBox.getPreferredSize());
        startingDateMonthBox.setLocation(720, 110);

        String[] startingDateDayItems = new String[32];
        for(int i = 0;i < startingDateDayItems.length;i++){
                    startingDateDayItems[i] = (i + 1) + "";
        }
        JComboBox<Object> startingDateDayBox = new JComboBox<Object>(startingDateDayItems);
        startingDateDayBox.setFont(mainFont);
        startingDateDayBox.setSize(startingDateDayBox.getPreferredSize());
        startingDateDayBox.setLocation(865, 110);

        JLabel instructorNameLabel = new JLabel("Instructor Name: ");
        instructorNameLabel.setFont(mainFont);
        instructorNameLabel.setForeground(Color.BLACK);
        instructorNameLabel.setSize(instructorNameLabel.getPreferredSize());
        instructorNameLabel.setLocation(23, 280);

        JTextField instructorNameField = new JTextField();
        instructorNameField.setForeground(Color.WHITE);
        instructorNameField.setOpaque(false);
        instructorNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        instructorNameField.setFont(mainFont);
        instructorNameField.setSize(175, 30);
        instructorNameField.setLocation(230, 280);

        JLabel completionDateLabel = new JLabel("Completion Date: ");
        completionDateLabel.setFont(mainFont);
        completionDateLabel.setSize(completionDateLabel.getPreferredSize());
        completionDateLabel.setLocation(455, 195);

        String[] completionDateYearItems = {"2021", "2022", "2023", "2024", "2025", "2026"};
        JComboBox<Object> completionDateYearBox = new JComboBox<Object>(completionDateYearItems);
        completionDateYearBox.setFont(mainFont);
        completionDateYearBox.setSize(completionDateYearBox.getPreferredSize());
        completionDateYearBox.setLocation(640, 195);

        String[] completionDateMonthItems = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
        JComboBox<Object> completionDateMonthBox = new JComboBox<Object>(completionDateMonthItems);
        completionDateMonthBox.setFont(mainFont);
        completionDateMonthBox.setSize(completionDateMonthBox.getPreferredSize());
        completionDateMonthBox.setLocation(720, 195);

        String[] completionDateDayItems = new String[32];
        for(int i = 0;i < completionDateDayItems.length;i++){
            completionDateDayItems[i] = (i + 1) + "";
        }
        JComboBox<Object> completionDateDayBox = new JComboBox<Object>(completionDateDayItems);
        completionDateDayBox.setFont(mainFont);
        completionDateDayBox.setSize(completionDateDayBox.getPreferredSize());
        completionDateDayBox.setLocation(865, 195);

        JLabel examDateLabel = new JLabel("Exam Date: ");
        examDateLabel.setFont(mainFont);
        examDateLabel.setSize(examDateLabel.getPreferredSize());
        examDateLabel.setLocation(519, 280);

        String[] examDateYearItems = {"2021", "2022", "2023", "2024", "2025", "2026"};
        JComboBox<Object> examDateYearBox = new JComboBox<Object>(examDateYearItems);
        examDateYearBox.setFont(mainFont);
        examDateYearBox.setSize(examDateYearBox.getPreferredSize());
        examDateYearBox.setLocation(640, 280);

        String[] examDateMonthItems = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December"};
        JComboBox<Object> examDateMonthBox = new JComboBox<Object>(examDateMonthItems);
        examDateMonthBox.setFont(mainFont);
        examDateMonthBox.setSize(examDateMonthBox.getPreferredSize());
        examDateMonthBox.setLocation(720, 280);

        String[] examDateDayItems = new String[32];
        for(int i = 0;i < examDateDayItems.length;i++){
            examDateDayItems[i] = (i + 1) + "";
        }
        JComboBox<Object> examDateDayBox = new JComboBox<Object>(examDateDayItems);
        examDateDayBox.setFont(mainFont);
        examDateDayBox.setSize(examDateDayBox.getPreferredSize());
        examDateDayBox.setLocation(865, 280);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        JButton registerButton = new JButton("Register");
        registerButton.setSize(125, 30);
        registerButton.setLocation(800, 400);
        registerButton.setFont(mainFont);

        JButton clearButton = new JButton("Clear");
        clearButton.setSize(125, 30);
        clearButton.setLocation(670, 400);
        clearButton.setFont(mainFont);

        //**** Action listeners here using anonymous class****
        registerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = (String) courseIdBox.getSelectedItem();

                    String courseLeader = courseLeaderField.getText();
                    String instructorName = instructorNameField.getText();

                    String startingDateYear = (String) startingDateYearBox.getSelectedItem();
                    String startingDateMonth = (String) startingDateMonthBox.getSelectedItem();
                    String startingDateDay = (String) startingDateDayBox.getSelectedItem();

                    String completionDateYear = (String) completionDateYearBox.getSelectedItem();
                    String completionDateMonth = (String) completionDateMonthBox.getSelectedItem();
                    String completionDateDay = (String) completionDateDayBox.getSelectedItem();

                    String examDateYear = (String) examDateYearBox.getSelectedItem();
                    String examDateMonth = (String) examDateMonthBox.getSelectedItem();
                    String examDateDay = (String) examDateDayBox.getSelectedItem();

                    String startingDate = startingDateYear + "-" + startingDateMonth + "-" + startingDateDay;
                    String completionDate = completionDateYear + "-" + completionDateMonth + "-" + completionDateDay;
                    String examDate = examDateYear + "-" + examDateMonth + "-" + examDateDay;

                    String startingMonthToInt = startingDateMonthBox.getSelectedIndex() + 1 + ""; //since indices start at 0 add 1 for actual month
                    String completionMonthToInt = completionDateMonthBox.getSelectedIndex() + 1 + ""; //since indices start at 0 add 1 for actual month
                    String examMonthToInt = examDateMonthBox.getSelectedIndex() + 1 + "";

                    if(courseId == null){
                        //no courses available to register
                        JOptionPane.showMessageDialog(registerNonAcademicFrame,
                            "No courses have been added to register yet!! Please add a non-academic course before registering!!",
                            "CourseList Empty Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    //invalid date order checks
                    if(!isFirstDateSmall(startingDateYear, startingMonthToInt, startingDateDay, completionDateYear, completionMonthToInt, completionDateDay)){
                        JOptionPane.showMessageDialog(registerNonAcademicFrame,
                            "Dates are not properly input. Starting Date must come before the Completion Date.",
                            "Date Order Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    if(!isFirstDateSmall(startingDateYear, startingMonthToInt, startingDateDay, examDateYear, examMonthToInt, examDateDay)){                    
                        JOptionPane.showMessageDialog(registerNonAcademicFrame,
                            "Dates are not properly input. Exam Date must come after the Starting Date.",
                            "Date Order Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    if(!isFirstDateSmall(examDateYear, examMonthToInt, examDateDay, completionDateYear, completionMonthToInt, completionDateDay)){
                        JOptionPane.showMessageDialog(registerNonAcademicFrame,
                            "Dates are not properly input. Exam Date must come before the Completion Date.",
                            "Date Order Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    //empty field checks
                    if(courseId.equals("") || courseLeader.equals("") || instructorName.equals("")){
                        JOptionPane.showMessageDialog(registerNonAcademicFrame,
                            "Please dont leave any fields empty!",
                            "Empty Field Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    for(Course c : allCourses){
                        if(c instanceof NonAcademicCourse){
                            NonAcademicCourse nac = (NonAcademicCourse) c;
                            if(nac.getCourseId().equals(courseId)){
                                //found the course register it
                                nac.registerCourse(courseLeader, instructorName, startingDate, completionDate, examDate); 

                                JOptionPane.showMessageDialog(registerNonAcademicFrame,"Successfully Registered.","Alert",JOptionPane.WARNING_MESSAGE); 

                                mainFrame.setVisible(true);
                                registerNonAcademicFrame.setVisible(false);
                                break;
                            }
                        }
                    }

                }
            });

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courseLeaderField.setText("");
                    instructorNameField.setText("");

                    mainFrame.setVisible(true);
                    registerNonAcademicFrame.setVisible(false);
                }
            });

        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    courseLeaderField.setText("");
                    instructorNameField.setText("");
                }
            });
        
            
        //add all the GUI components to the JPanel
        mainContainer.add(courseIdLabel);
        mainContainer.add(courseIdBox);
        mainContainer.add(courseLeaderLabel);
        mainContainer.add(courseLeaderField);
        mainContainer.add(startingDateLabel);
        mainContainer.add(startingDateYearBox);
        mainContainer.add(startingDateMonthBox);
        mainContainer.add(startingDateDayBox);
        mainContainer.add(completionDateLabel);
        mainContainer.add(completionDateYearBox);
        mainContainer.add(completionDateMonthBox);
        mainContainer.add(completionDateDayBox);
        mainContainer.add(examDateLabel);
        mainContainer.add(examDateYearBox);
        mainContainer.add(examDateMonthBox);
        mainContainer.add(examDateDayBox);
        mainContainer.add(instructorNameLabel);
        mainContainer.add(instructorNameField);
        mainContainer.add(registerButton);
        mainContainer.add(clearButton);
        mainContainer.add(backButton);

        registerNonAcademicFrame.add(mainContainer);
    }

    public void makeRemoveNonAcademicFrame(){
        removeNonAcademicFrame = new JFrame("Remove Non-Academic Course");

        JPanel mainContainer = new JPanel();

        removeNonAcademicFrame.setSize(600, 600);
        removeNonAcademicFrame.setResizable(false);
        removeNonAcademicFrame.setLayout(null);

        mainContainer.setSize(600, 600);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        removeNonAcademicFrame.getContentPane().setBackground(backgroundColor);
        
        //make all the GUI components
        JLabel removeLabel = new JLabel("Remove:");
        removeLabel.setFont(headingFont);
        removeLabel.setSize(removeLabel.getPreferredSize());
        removeLabel.setLocation(220, 150);

        JComboBox<Object> removableCoursesBox = new JComboBox<Object>(getRegisteredNonAcademicCourses());
        removableCoursesBox.setFont(mainFont);
        removableCoursesBox.setSize(400, 40);
        removableCoursesBox.setLocation(100, 200);

        JButton removeButton = new JButton("Remove");
        removeButton.setSize(300, 70);
        removeButton.setLocation(150, 350);
        removeButton.setFont(headingFont);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mainFrame.setVisible(true);
                    removeNonAcademicFrame.setVisible(false);
                }
            });

        removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = (String) removableCoursesBox.getSelectedItem();
                    
                    //no courses availabel to remove
                    if(courseId == null){
                        JOptionPane.showMessageDialog(removeNonAcademicFrame,
                            "No courses can be removed yet!! Please add a non-academic course before removing!!",
                            "CourseList Empty Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }
                    
                    for(Course c : allCourses){
                        if(c instanceof NonAcademicCourse){
                            NonAcademicCourse nac = (NonAcademicCourse) c;
                            if(nac.getCourseId().equals(courseId)){
                                //remove this course
                                nac.removeCourse();
                                allCourses.remove(c);

                                JOptionPane.showMessageDialog(removeNonAcademicFrame,"Successfully Removed.","Alert",JOptionPane.WARNING_MESSAGE); 

                                mainFrame.setVisible(true);
                                removeNonAcademicFrame.setVisible(false);
                                
                                break;
                            }
                        }
                    }

                }
            });

        mainContainer.add(removeLabel);
        mainContainer.add(removableCoursesBox);
        mainContainer.add(removeButton);     
        mainContainer.add(backButton);

        removeNonAcademicFrame.add(mainContainer);
    }

    public void makeDisplayAcademicFrame(){
        displayAcademicFrame = new JFrame("Display Non-Academic Course");

        JPanel mainContainer = new JPanel();

        displayAcademicFrame.setSize(600, 600);
        displayAcademicFrame.setResizable(false);
        displayAcademicFrame.setLayout(null);

        mainContainer.setSize(600, 600);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        displayAcademicFrame.getContentPane().setBackground(backgroundColor);
            
        //make all the GUI components
        JLabel displayLabel = new JLabel("Display Academic:");
        displayLabel.setFont(headingFont);
        displayLabel.setSize(displayLabel.getPreferredSize());
        displayLabel.setLocation(100, 100);

        JComboBox<Object> allAcademicCoursesBox = new JComboBox<Object>(getAllAcademicCourses());
        allAcademicCoursesBox.setFont(mainFont);
        allAcademicCoursesBox.setSize(400, 40);
        allAcademicCoursesBox.setLocation(100, 200);

        JButton displayButton = new JButton("Display");
        displayButton.setSize(300, 70);
        displayButton.setLocation(150, 350);
        displayButton.setFont(headingFont);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mainFrame.setVisible(true);
                    displayAcademicFrame.setVisible(false);
                }
            });

        displayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = (String) allAcademicCoursesBox.getSelectedItem();
                    
                    //no courses available for displaying
                    if(courseId == null){
                        JOptionPane.showMessageDialog(displayAcademicFrame,
                            "No courses can be displayed yet!! Please add an academic course before displaying!!",
                            "CourseList Empty Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    for(Course c : allCourses){
                        if(c instanceof AcademicCourse){
                            AcademicCourse ac = (AcademicCourse) c;

                            if(ac.getCourseId().equals(courseId)){
                                //display the details of this course
                                String messageToShow = "";

                                messageToShow += "The Course Name of course ID " + courseId + " is " + ac.getCourseName() + " and the duration of the course is " + ac.getDuration() + ". \n";

                                if (!ac.getCourseLeader().equals("")) {
                                    messageToShow += "The Course Leader for this course is " + ac.getCourseLeader() + ". \n";
                                }

                                if (ac.getIsRegistered()) {
                                    messageToShow += "The lecturer for this course is " + ac.getLecturerName() + ". \n";
                                    messageToShow +="The level of this course is " + ac.getLevel() + ". \n";
                                    messageToShow +="The credit for this course is " + ac.getCredit() + " and there are " + ac.getNoOfAssessments() + " assignments in the course"+ ". \n";
                                    messageToShow +="The course begins on " + ac.getStartingDate() + " and it ends on " + ac.getCompletionDate() + ". \n";
                                } else {
                                    messageToShow +="The course is not registered yet to show any details! \n";
                                }

                                JOptionPane.showMessageDialog(displayAcademicFrame,messageToShow,"Course Details",JOptionPane.INFORMATION_MESSAGE); 
                                break;
                            }
                        }
                    }
                }
            });
        
        //add these GUI components to JPanel
        mainContainer.add(displayLabel);
        mainContainer.add(allAcademicCoursesBox);
        mainContainer.add(displayButton);     
        mainContainer.add(backButton);

        displayAcademicFrame.add(mainContainer);
    }

    public void makeDisplayNonAcademicFrame(){
        displayNonAcademicFrame = new JFrame("Display Non-Academic Course");

        JPanel mainContainer = new JPanel();

        displayNonAcademicFrame.setSize(600, 600);
        displayNonAcademicFrame.setResizable(false);
        displayAcademicFrame.setLayout(null);

        mainContainer.setSize(600, 600);
        mainContainer.setLocation(0, 0);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(false);
        displayNonAcademicFrame.getContentPane().setBackground(backgroundColor);

        JLabel displayLabel = new JLabel("Display Non-Academic:");
        displayLabel.setFont(headingFont);
        displayLabel.setSize(displayLabel.getPreferredSize());
        displayLabel.setLocation(50, 100);

        JComboBox<Object> allNonAcademicCoursesBox = new JComboBox<Object>(getAllNonAcademicCourses());
        allNonAcademicCoursesBox.setFont(mainFont);
        allNonAcademicCoursesBox.setSize(400, 40);
        allNonAcademicCoursesBox.setLocation(100, 200);

        JButton displayButton = new JButton("Display");
        displayButton.setSize(300, 70);
        displayButton.setLocation(150, 350);
        displayButton.setFont(headingFont);

        JButton backButton = new JButton("Back To Main");
        backButton.setSize(180, 30);
        backButton.setLocation(20, 20);
        backButton.setFont(mainFont);

        backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mainFrame.setVisible(true);
                    displayNonAcademicFrame.setVisible(false);
                }
            });

        displayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseId = (String) allNonAcademicCoursesBox.getSelectedItem();
                    
                    //no courses avaialble to display
                    if(courseId == null){
                        JOptionPane.showMessageDialog(displayNonAcademicFrame,
                            "No courses can be displayed yet!! Please add an non-academic course before displaying!!",
                            "CourseList Empty Error",
                            JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    for(Course c : allCourses){
                        if(c instanceof NonAcademicCourse){
                            NonAcademicCourse nac = (NonAcademicCourse) c;

                            if(nac.getCourseId().equals(courseId)){
                                //show the details of this course
                                String messageToShow = "";

                                messageToShow += "The Course Name of course ID " + courseId + " is " + nac.getCourseName() + " and the duration of the course is " + nac.getDuration() + ". \n";

                                if (!nac.getCourseLeader().equals("")) {
                                    messageToShow += "The Course Leader for this course is " + nac.getCourseLeader() + ". \n";
                                }

                                if (nac.getIsRegistered()) {
                                    messageToShow += "The instructor for this course is " + nac.getInstructorName() + ". \n";
                                    messageToShow += "The course is beginning on " + nac.getStartingDate() + " and it ends on " + nac.getCompletionDate() + ". \n";
                                    messageToShow +="The course will have an exam on " + nac.getExamDate() + ". \n";
                                    messageToShow +="The prerequisiste for this course is "+ nac.getPrerequisite() + ". \n";
                                } else {
                                    messageToShow +="The course is not registered yet to show any details! \n";
                                }

                                JOptionPane.showMessageDialog(displayAcademicFrame,messageToShow,"Course Details",JOptionPane.INFORMATION_MESSAGE); 
                                break;
                            }
                        }
                    }
                }
            });

        mainContainer.add(displayLabel);
        mainContainer.add(allNonAcademicCoursesBox);
        mainContainer.add(displayButton);     
        mainContainer.add(backButton);

        displayNonAcademicFrame.add(mainContainer);
    }
    
    //get an array of courseIds of unregistered academicCourses
    public Object[] getUnregisteredAcademicCourses(){
        //arraylist because size to return is not constant
        ArrayList<String> unregisteredAcademicCoursesList = new ArrayList<String>(); 
        for(Course c : allCourses){
            if(c instanceof AcademicCourse){
                AcademicCourse ac = (AcademicCourse) c;
                if(!ac.getIsRegistered()){
                    unregisteredAcademicCoursesList.add(ac.getCourseId());
                }
            }
        }
        return unregisteredAcademicCoursesList.toArray();
    }

    //get an array of courseIds of unregistered non-academicCourses
    public Object[] getUnregisteredNonAcademicCourses(){
        //arraylist because size to return is not constant
        ArrayList<String> unregisteredNonAcademicCourses = new ArrayList<String>(); 
        for(Course c : allCourses){
            if(c instanceof NonAcademicCourse){
                NonAcademicCourse nac = (NonAcademicCourse) c;
                if(!nac.getIsRegistered()){
                    unregisteredNonAcademicCourses.add(nac.getCourseId());
                }
            }
        }
        return unregisteredNonAcademicCourses.toArray();
    }

    //get an array of courseIds of registered non-academicCourses
    public Object[] getRegisteredNonAcademicCourses(){
        //arraylist because size to return is not constant
        ArrayList<String> unregisteredNonAcademicCourses = new ArrayList<String>(); 
        for(Course c : allCourses){
            if(c instanceof NonAcademicCourse){
                NonAcademicCourse nac = (NonAcademicCourse) c;
                if(nac.getIsRegistered()){
                    unregisteredNonAcademicCourses.add(nac.getCourseId());
                }
            }
        }
        return unregisteredNonAcademicCourses.toArray();
    }

    //get an array of courseIds of all academicCourses
    public Object[] getAllAcademicCourses(){
        //arraylist because size to return is not constant
        ArrayList<String> allAcademicCourses = new ArrayList<String>(); 
        for(Course c : allCourses){
            if(c instanceof AcademicCourse){
                AcademicCourse ac = (AcademicCourse) c;
                allAcademicCourses.add(ac.getCourseId());
            }
        }
        return allAcademicCourses.toArray();
    }
    
    //get an array of courseIds of all non-academicCourses
    public Object[] getAllNonAcademicCourses(){
        //arraylist because size to return is not constant
        ArrayList<String> allNonAcademicCourses = new ArrayList<String>(); 
        for(Course c : allCourses){
            if(c instanceof NonAcademicCourse){
                NonAcademicCourse nac = (NonAcademicCourse) c;
                allNonAcademicCourses.add(nac.getCourseId());
            }
        }
        return allNonAcademicCourses.toArray();
    }
    
    //takes 6 parameters: 3 for date1, 3 for date2 and return whether date1 comes before date 2 in a calendar
    public boolean isFirstDateSmall(String year1, String month1, String day1, String year2, String month2, String day2){
        Date firstDate = new Date(Integer.parseInt(year1), Integer.parseInt(month1), Integer.parseInt(day1));
        Date secondDate = new Date(Integer.parseInt(year2), Integer.parseInt(month2), Integer.parseInt(day2));
        
        //check is firstDate is greater than second
        if(firstDate.getTime() >= secondDate.getTime()){
            return false;
        }
        return true;
    }
    
    //main method for the class
    public static void main(String[] args){
        //call the constructor for INGCollege for GUI
        new INGCollege();
    }

}
