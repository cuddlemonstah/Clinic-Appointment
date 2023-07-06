
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoConfirmation extends JFrame {

    Scheduler sched = new Scheduler();
    InfoConfirmation(){

        sched.Inform();
        sched.Text();
        sched.toSchedule();
        
        this.getContentPane();
        this.setTitle("Schedule");
        this.setResizable(false);
        this.setSize(820, 500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.add(sched.InfoP);
        this.add(sched.dateSchedule);
        this.add(sched.Submission);
        this.add(sched.Name);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new InfoConfirmation();
    }
   
    
}
