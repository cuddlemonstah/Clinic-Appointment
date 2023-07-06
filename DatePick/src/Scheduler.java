import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.util.*;


public class Scheduler extends JFrame implements ActionListener{

    String lastname;
    String firstname;
    String MidInitial;
    String Callnumber;
    String personAge;
    String Birthday;
    String Occupation;
    String Gender;
    String Bdate = "00-00-0000";
    String Picked = "00-00-0000";
    String Timepicked;

    String fullname;
    
    //JFrame for InfoConfirmation
    JFrame frame = new JFrame();
    JPanel Npanel1 = new JPanel();
    JPanel Npanel = new JPanel();
    JButton Yes = new JButton();
    JButton No = new JButton();
    JLabel YesNoLabel = new JLabel();
    JLabel InfoTitle = new JLabel();
    JLabel ILName = new JLabel();
    JLabel ilName = new JLabel();
    JLabel InfoAge = new JLabel();
    JLabel IAge = new JLabel();
    JLabel InfoBirthdate = new JLabel();
    JLabel IBirthdate = new JLabel();
    JLabel InfoGender = new JLabel();
    JLabel IGender = new JLabel();
    JLabel InfoOccupation = new JLabel();
    JLabel IOccupation = new JLabel();
    JLabel ScheduleTitle = new JLabel();
    JLabel InfoDatep = new JLabel();
    JLabel IDatep = new JLabel();
    JLabel InfoTimep = new JLabel();
    JLabel ITimep = new JLabel();
    
    //border
    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);

    
    //JLabel
    /**Inform() Name*/
    JLabel Fname;
    JLabel Lname;
    JLabel MI;
    /**Inform() Phone Number, Gender, and Occupation*/
    JLabel numAge;
    JLabel PNumber;
    JLabel GenderT;
    JLabel OccupationT;
    JLabel Birthdate;
   
    //Textfield
    JTextField fname;
    JTextField lname;
    JTextField pnumber;
    JTextField GOthers;
    JTextField OcuOthers;
    JTextField BDay;
    JTextField Age;
    //RadioButton
    /**Gender */
    JRadioButton male;
    JRadioButton female;
    JRadioButton others;
    /**Occupation */
    JRadioButton student;
    JRadioButton employee;
    JRadioButton Ocothers;
    //JComboBox
    /**Middle Initial */
    String[] MidIn = {"A","B","C","D","E","F","G","H","I","J","K",
                        "L","M","N","O","P","Q","R","S","T","U","V",
                        "W","X","Y","Z"};
    JComboBox mi;

    //RadioButton Group
    ButtonGroup genderGroup;
    ButtonGroup occupationGroup;

    //JcheckBox
    JCheckBox ConfirmInfo;

    

    //Text()
    JLabel Name;
 
    //ToSchedule()
    JPanel Submission;
    JPanel dateSchedule;
    JButton schedbtn = new JButton();
    JButton subtn = new JButton();
    JLabel DateSched;
    String[] timeAvail = {"7:00 AM - 8:00 AM",
    "8:00 AM - 9:00 AM",
    "9:00 AM - 10:00 AM",
    "10:00 AM - 11:00 AM",
    "1:00 AM - 2:00 AM",
    "2:00 AM - 3:00 AM",
    "3:00 AM - 4:00 AM",};
    JComboBox pickTime;
    JLabel schedTime;
    JLabel dateSelected;
    JPanel fconbtn;
    JButton schedBTN = new JButton();
    JLabel pickedDate;


    //Inform()
    JPanel InfoP;

    JPanel smallpanel;

    JButton birthd = new JButton();
    JButton BdayCheck =  new JButton();
    JButton conbtn;

    //CalendarDatePicker()
    App date;

    ImageIcon Image = new ImageIcon(getClass().getClassLoader().getResource("TDSlogo1.png"));
    
    Scheduler(){


        Inform();
        Text();
        toSchedule();
        
        this.getContentPane();
        this.setTitle("Schedule");
        this.setResizable(false);
        this.setSize(820, 500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setIconImage(Image.getImage());
        this.add(InfoP);
        this.add(dateSchedule);
        this.add(Submission);
        this.add(Name);
        this.setVisible(true);

    }

    void Text(){

        Name = new JLabel();
        Name.setFont(new Font("Arial", Font.BOLD, 20));
        Name.setText("Put Information!");
        Name.setHorizontalAlignment(JLabel.CENTER);
        Name.setVerticalAlignment(JLabel.TOP);
        Name.setIconTextGap(10);
        Name.setBackground(new Color(0xe8e4c9));
        Name.setOpaque(true);
        Name.setBounds(0, 0, 820, 30);
        Name.setLayout(null);

        //Button
        
    }


    void Inform(){

        int width = 150;
        int twidth = 125;
        int height = 20;
        //Text Fields
        /**Name */
        fname = new JTextField();
        lname = new JTextField();
        mi = new JComboBox(MidIn);
        mi.addActionListener(this);
        /**Birthday */
        BDay = new JTextField();
        BDay.setEditable(false);
        BDay.setBackground(Color.white);
        /**Phone number */
        pnumber = new JTextField();
        /**Gender */
        GOthers = new JTextField();
        GOthers.setEditable(false);
        GOthers.setBackground(Color.BLACK);
        /**Occupation */
        OcuOthers = new JTextField();
        OcuOthers.setEditable(false);
        OcuOthers.setBackground(Color.BLACK);
        /**Age */
        Age = new JTextField();

        //Radio Button
        /**Gender */
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others:");
        /**Occupation */
        student = new JRadioButton("Student");
        employee = new JRadioButton("Employee");
        Ocothers = new JRadioButton("Others:");

        //
        /**First name */
        Fname = new JLabel();
        Fname.setFont(new Font("Arial", Font.BOLD, 15));
        Fname.setText("First Name:");
        Fname.setBounds(30, 20, width, height);
        /**Last name */
        Lname = new JLabel();
        Lname.setFont(new Font("Arial", Font.BOLD, 15));
        Lname.setText("Last Name:");
        Lname.setBounds(250, 20, width, height);
        /**Middle Initial */
        MI = new JLabel();
        MI.setFont(new Font("Arial", Font.BOLD, 15));
        MI.setText("M.I:");
        MI.setBounds(490, 20, width, height);
        /**Age */
        numAge = new JLabel();
        numAge.setFont(new Font("Arial", Font.BOLD, 15));
        numAge.setText("Age: ");
        numAge.setBounds(30, 110, width, height);
        /**Birth Date */
        Birthdate = new JLabel();
        Birthdate.setFont(new Font("Arial", Font.BOLD, 15));
        Birthdate.setText("Birth Date:");
        Birthdate.setBounds(30, 60, width, height);
        /**Phone number */
        PNumber = new JLabel();
        PNumber.setFont(new Font("Arial", Font.BOLD, 15));
        PNumber.setText("Phone Number:");
        PNumber.setBounds(30, 160, width, height);
        /**Gender */
        GenderT = new JLabel();
        GenderT.setFont(new Font("Arial", Font.BOLD, 15));
        GenderT.setText("Gender:");
        GenderT.setBounds(300, 60, width, height);
        /**Occupation */
        OccupationT = new JLabel();
        OccupationT.setFont(new Font("Arial", Font.BOLD, 15));
        OccupationT.setText("Occupation:");
        OccupationT.setBounds(440, 60, width, height);
        

        //Fname
        fname.setBounds(115, 20, twidth, height);
        fname.setText("Enter First Name:");
        //Lname
        lname.setBounds(330, 20, twidth, height);
        lname.setText("Enter Last Name:");
        //Middle Initial
        mi.setBounds(520, 20, 40, height);
        //phone number
        pnumber.setBounds(145, 160, twidth, height);
        pnumber.setText("Enter Phone number");
        //Age
        Age.setBounds(70, 110, width, height);
        Age.setText("Enter Age: ");
        

        //button
        conbtn = new JButton();
        conbtn.setText("C");
        conbtn.setBackground(new Color(0xdee8ec));
        conbtn.setBounds(0, 0, 20, 20);
        conbtn.addActionListener(this);
        conbtn.setBorder(BorderFactory.createEtchedBorder());
        smallpanel = new JPanel();
        smallpanel .setBackground(Color.darkGray);
        smallpanel .setBounds(240, 60, 20, 20);
        smallpanel.setLayout(null);
        smallpanel.add(conbtn);
        BDay.setBounds(110,60,100,height);
        BDay.setText(Bdate);
 

        //Birtdate Btn
        birthd.setText("...");
        birthd.setBackground(new Color(0xdee8ec));
        birthd.setBounds(215, 60, 20, 20);
        birthd.addActionListener(this);
        birthd.setBorder(BorderFactory.createEtchedBorder());

        
        //Gender
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);
        male.setBounds(330, 80, 70, 20);
        male.setBackground(Color.gray);
        male.addActionListener(this);
        female.setBounds(330,110, 70, 20);
        female.setBackground(Color.gray);
        female.addActionListener(this);
        others.setBounds(330,140, 70, 20);
        others.setBackground(Color.gray);
        others.addActionListener(this);
        GOthers.setBounds(350,160, 75, height);
        GOthers.setText("Others:");
        //Occupation
        occupationGroup = new ButtonGroup();
        occupationGroup.add(student);
        occupationGroup.add(employee);
        occupationGroup.add(Ocothers);
        student.setBounds(480, 80, 70, 20);
        student.setBackground(Color.gray);
        student.addActionListener(this);
        employee.setBounds(480, 110, 100, 20);
        employee.setBackground(Color.gray);
        employee.addActionListener(this);
        Ocothers.setBounds(480, 140, 70, 20);
        Ocothers.setBackground(Color.gray);
        Ocothers.addActionListener(this);
        OcuOthers.setBounds(500, 160, 70, height);
        OcuOthers.setText("Others:");

        //Confirmation
        ConfirmInfo = new JCheckBox();
        ConfirmInfo.setText("Is this the right information?");
        ConfirmInfo.setBounds(220, 300, 200, height);
        ConfirmInfo.setBackground(new Color(0xe8e4c9));
        
        InfoP = new JPanel();      
        InfoP.setBackground(Color.GRAY);
        InfoP.setBounds(0, 30, 622, 470);
        InfoP.setBorder(border);
        InfoP.setLayout(null);

        //Name
        InfoP.add(fname);
        InfoP.add(lname);
        InfoP.add(pnumber);
        InfoP.add(mi);
        //Age
        InfoP.add(Age);
        //Birthdate
        InfoP.add(BDay);
        InfoP.add(birthd);
        InfoP.add(smallpanel);
        
        //Gender
        InfoP.add(male);
        InfoP.add(female);
        InfoP.add(others);
        InfoP.add(GOthers);
        //Occupation
        InfoP.add(student);
        InfoP.add(employee);
        InfoP.add(Ocothers);
        InfoP.add(OcuOthers);

        //Text Labels
        InfoP.add(Fname);
        InfoP.add(Lname);
        InfoP.add(MI);
        InfoP.add(numAge);
        InfoP.add(PNumber);
        InfoP.add(GenderT);
        InfoP.add(OccupationT);
        InfoP.add(Birthdate);

        //Confirmation
        InfoP.add(ConfirmInfo);

        //Date picker  
    }

    void toSchedule(){

        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
        

        //Submission
        /**Submission button*/
        subtn.setText("Submit");
        subtn.setBackground(new Color(0xdee8ec));
        subtn.setBounds(17, 360, 150, 40);
        subtn.addActionListener(this);
        subtn.setBorder(BorderFactory.createEtchedBorder());
        
        /**Submission Panel*/
        Submission = new JPanel();
        Submission.setBackground(Color.darkGray);
        Submission.setBounds(622, 30, 200, 470);
        Submission.setLayout(null);

        //Scheduling Date
        /**Schedule Text */ 
        DateSched = new JLabel();
        DateSched.setFont(new Font("Arial", Font.BOLD, 15));
        DateSched.setText("Scheduling Date");
        DateSched.setBounds(35, 10, 150, 30);
        DateSched.setForeground(Color.white);

        pickedDate = new JLabel();
        pickedDate.setFont(new Font("Arial", Font.BOLD, 12));
        pickedDate.setText("Date Picked:");
        pickedDate.setBounds(50, 150, 150, 30);
        pickedDate.setForeground(Color.white);

        /**Scheduling panel*/
        dateSchedule = new JPanel();
        dateSchedule.setBackground(Color.gray);
        dateSchedule.setBounds(660, 70, 110, 110);
        dateSchedule.setLayout(null);
        dateSchedule.add(schedbtn);
        
        /**scheduling button*/
        schedbtn.setText("Schedule");
        schedbtn.setBackground(new Color(0xdee8ec));
        schedbtn.setBounds(0, 0, 110, 110);
        schedbtn.addActionListener(this);
        schedbtn.setBorder(BorderFactory.createEtchedBorder());

        /**Date Selected */
        dateSelected = new JLabel();
        dateSelected.setText(Picked);
        dateSelected.setBackground(new Color(0xdee8ec));
        dateSelected.setBounds(60, 130, 110, 110);
        dateSelected.setForeground(Color.white);

        //Scheduling Time
        /**Label */
        schedTime = new JLabel();
        schedTime.setFont(new Font("Arial", Font.BOLD, 15));
        schedTime.setText("Schedule Time");
        schedTime.setBounds(40, 220, 150, 30);
        schedTime.setForeground(Color.white);

        /**combo box */
        pickTime = new JComboBox(timeAvail);
        pickTime.setBounds(20, 250, 150, 30);

        schedBTN = new JButton();
        schedBTN.setText("L");
        schedBTN.setBackground(new Color(0xdee8ec));
        schedBTN.setBounds(0, 0, 15,15);
        schedBTN.addActionListener(this);
        schedBTN.setBorder(BorderFactory.createEtchedBorder());
        fconbtn = new JPanel();
        fconbtn .setBackground(Color.darkGray);
        fconbtn .setBounds(127, 155, 15, 15);
        fconbtn.setLayout(null);
        fconbtn.add(schedBTN);


        //Add
        Submission.add(DateSched);
        Submission.add(subtn);   
        Submission.add(pickTime);
        Submission.add(schedTime);
        Submission.add(dateSelected);
        Submission.add(fconbtn);
        Submission.add(pickedDate);
    }

    void InfoConfirmation(){

        frame.getContentPane();
        frame.setTitle("Schedule");
        frame.setResizable(false);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.add(Npanel1);
        frame.add(Npanel);
        frame.setVisible(true);
    
        YesNoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        YesNoLabel.setBounds(160, 280, 500, 30);
        YesNoLabel.setText("Is this information right?");

        Yes.setText("Yes");
        Yes.setBackground(new Color(0xdee8ec));
        Yes.setBounds(130, 310, 100, 30);
        Yes.addActionListener(this);
        Yes.setBorder(BorderFactory.createEtchedBorder());

        No.setText("No");
        No.setBackground(new Color(0xdee8ec));
        No.setBounds(260, 310, 100, 30);
        No.addActionListener(this);
        No.setBorder(BorderFactory.createEtchedBorder());


        InfoTitle.setFont(new Font("Arial", Font.BOLD, 20));
        InfoTitle.setBounds(150, 0, 500, 30);
        InfoTitle.setText("Information");

        ILName.setFont(new Font("Arial", Font.BOLD, 15));
        ILName.setBounds(30, 30, 50, 30);
        ILName.setText("Name: ");
        ilName.setFont(new Font("Arial", Font.BOLD, 15));
        ilName.setBounds(80, 30, 500, 30);
        ilName.setText(fullname);

        InfoAge.setFont(new Font("Arial", Font.BOLD, 15));
        InfoAge.setBounds(30, 60, 100, 30);
        InfoAge.setText("Age:");
        IAge.setFont(new Font("Arial", Font.BOLD, 15));
        IAge.setBounds(65, 60, 500, 30);
        IAge.setText(personAge);

        InfoBirthdate.setFont(new Font("Arial", Font.BOLD, 15));
        InfoBirthdate.setBounds(30, 90, 100, 30);
        InfoBirthdate.setText("Birth Date:");
        IBirthdate.setFont(new Font("Arial", Font.BOLD, 15));
        IBirthdate.setBounds(110, 90, 500, 30);
        IBirthdate.setText(Birthday);

        InfoGender.setFont(new Font("Arial", Font.BOLD, 15));
        InfoGender.setBounds(30,120, 100, 30);
        InfoGender.setText("Gender:");
        IGender.setFont(new Font("Arial", Font.BOLD, 15));
        IGender.setBounds(90, 120, 500, 30);
        IGender.setText(Gender);

        InfoOccupation.setFont(new Font("Arial", Font.BOLD, 15));
        InfoOccupation.setBounds(200,120, 100, 30);
        InfoOccupation.setText("Occupation:");
        IOccupation.setFont(new Font("Arial", Font.BOLD, 15));
        IOccupation.setBounds(290, 120, 500, 30);
        IOccupation.setText(Occupation);

        ScheduleTitle.setFont(new Font("Arial", Font.BOLD, 18));
        ScheduleTitle.setBounds(150, 150, 100, 30);
        ScheduleTitle.setText("Scheduled");

        InfoDatep.setFont(new Font("Arial", Font.BOLD, 15));
        InfoDatep.setBounds(120,180, 100, 30);
        InfoDatep.setText("Date:");
        IDatep.setFont(new Font("Arial", Font.BOLD, 15));
        IDatep.setBounds(160, 180, 500, 30);
        IDatep.setText(Picked);

        InfoTimep.setFont(new Font("Arial", Font.BOLD, 15));
        InfoTimep.setBounds(120, 210, 100, 30);
        InfoTimep.setText("Time: ");
        ITimep.setFont(new Font("Arial", Font.BOLD, 15));
        ITimep.setBounds(160, 210 , 500, 30);
        ITimep.setText(Timepicked);

        Npanel.setBounds(0, 0, 500, 400);
        Npanel.setBackground(Color.gray);
        Npanel.add(Yes);
        Npanel.add(No);
        Npanel.add(YesNoLabel);
        Npanel.setLayout(null);
        
        Npanel1.setBounds(40, 30, 400, 250);
        Npanel1.setBackground(new Color(0xe8e4c9));
        Npanel1.add(ILName);
        Npanel1.add(ilName);
        Npanel1.add(InfoAge);
        Npanel1.add(IAge);
        Npanel1.add(InfoBirthdate);
        Npanel1.add(IBirthdate);
        Npanel1.add(InfoGender);
        Npanel1.add(IGender);
        Npanel1.add(InfoOccupation);
        Npanel1.add(IOccupation);
        Npanel1.add(ScheduleTitle);
        Npanel1.add(InfoDatep);
        Npanel1.add(IDatep);
        Npanel1.add(InfoTimep);
        Npanel1.add(ITimep);
        Npanel1.add(InfoTitle);
        Npanel1.setLayout(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Gender Radio Buttons
        if(e.getSource() == others){
           GOthers.setEditable(true);
            Gender = GOthers.getText();
           GOthers.setBackground(Color.WHITE);
        }
        else if(e.getSource() == male){
            GOthers.setEditable(false);
            Gender = male.getText();
            GOthers.setBackground(Color.BLACK);
        }
        else if(e.getSource() == female){
            GOthers.setEditable(false);
            Gender = female.getText();
            GOthers.setBackground(Color.BLACK);
        }

        //Occupation Radio Buttons
        if(e.getSource() == Ocothers){
            OcuOthers.setEditable(true);
            Occupation = OcuOthers.getText();
            OcuOthers.setBackground(Color.white);
         }
         else if(e.getSource() == student){
            OcuOthers.setEditable(false);
            Occupation = student.getText();
            OcuOthers.setBackground(Color.BLACK);
         }
         else if(e.getSource() == employee){
            OcuOthers.setEditable(false);
            Occupation = employee.getText();
            OcuOthers.setBackground(Color.BLACK);
         }


         if(e.getSource() == subtn && ConfirmInfo.isSelected()){

            this.dispose();
            
            InfoConfirmation();

            MidInitial = (String)mi.getSelectedItem();
            Timepicked = (String)pickTime.getSelectedItem();

            firstname = fname.getText();
            lastname = lname.getText();
            personAge = Age.getText();
            Birthday = BDay.getText();
            Callnumber = pnumber.getText();

            fullname = lastname + ", " + firstname + " " + MidInitial + ".";

            InfoConfirmation();
            
         }
         else if(e.getSource() == subtn){
            
            JOptionPane.showMessageDialog(null, "Check the box first","Need to fill out", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
            
         }

         /**Birthdate */
         if(e.getSource() == birthd){ 
            date = new App();
         }
         if(e.getSource() == conbtn){
            date.hay.dispose();
            Bdate = date.strDate;
            BDay.setText(Bdate);
        }
        if(e.getSource() == schedbtn){

            date = new App();
            dateSelected.setText(Picked);
        }
        if(e.getSource() == schedBTN){
            date.hay.dispose();
            Picked = date.strDate;
            dateSelected.setText(Picked);
        }
         
        if(e.getSource() == Yes){

            String fileName = "Patient.txt";
            try {PrintWriter outputStream = new PrintWriter(fileName);

                outputStream.println ("Full name : "+fullname);
                outputStream.println ("Birth Date : "+Birthday);
                outputStream.println ("Age : "+personAge);
                outputStream.println ("Gender : "+Gender);
                outputStream.println ("Occupation : "+Occupation);
                outputStream.println ("Phone Number : "+Callnumber);
                outputStream.println ("Scheduled Date : "+Picked);
                outputStream.println ("Scheduled Time : "+Timepicked);
                outputStream.close();

            }catch (Exception w){
                w.printStackTrace();
            }

            
        }
        else if(e.getSource() == No){
            new Scheduler();
            frame.dispose();
        }
    }  
}
