import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

public class Pick extends JFrame implements ActionListener {


    ImageIcon Image = new ImageIcon(getClass().getClassLoader().getResource("TDSlogo1.png"));
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    Border border1 = BorderFactory.createLineBorder(Color.darkGray, 2);
    static JButton btn;
    static JButton btn1;
    JPanel Dgreypanel;
    JPanel Dwhitepanel;
    JPanel Dwhitepanel1;
    JPanel ForBtn;

    
    public static void main(String[] args) {
        
        new Pick();
    }

   
    Pick(){

       AppointLabel();
       CheckAppointment();

       //Appointment Button
       btn = new JButton();
       btn.setText("Schedule");
       btn.setBackground(new Color(0xdee8ec));
       btn.setPreferredSize(new DimensionUIResource(205, 30));
       btn.addActionListener(this);
       btn.setBorder(BorderFactory.createEtchedBorder());

       //Check Appointment Button
       btn1 = new JButton();
       btn1.setBackground(new Color(0xdee8ec));
       btn1.setText("Check Appointments");
       btn1.setPreferredSize(new DimensionUIResource(205, 30));
       btn1.addActionListener(this);
       btn1.setBorder(BorderFactory.createEtchedBorder());

        Panels();
    
        this.setVisible(true);
        this.setTitle("Appoint");
        this.setResizable(false);
        this.setSize(820, 500);
        this.setDefaultCloseOperation(Pick.EXIT_ON_CLOSE);
        this.setIconImage(Image.getImage()); 
        this.setLayout(null);
        this.add(Dgreypanel); 
        this.add(Dwhitepanel);   
        this.add(Dwhitepanel1);       
        this.add(label);
        this.add(label1);
    }

    void AppointLabel(){
        
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(new Color(0xe8e4c9));
        label.setText("Appointments");
        label.setIcon(Image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIconTextGap(10);
        label.setBackground(Color.GRAY);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 410, 500);
    }

    void CheckAppointment(){
        
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        label1.setForeground(new Color(0xe8e4c9));
        label1.setText("Appoint a schedule!");
        label1.setIcon(Image);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setIconTextGap(10);
        label1.setBackground(Color.GRAY);
        label1.setOpaque(true);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setBounds(410, 0, 410, 500);

    }

    void Panels(){

        Dgreypanel = new JPanel();
        Dgreypanel.setBackground(Color.darkGray);
        Dgreypanel.setBounds(405, 0, 10, 400);
        
 
        Dwhitepanel = new JPanel();
        Dwhitepanel.setBackground(new Color(0xe8e4c9));
        Dwhitepanel.setBounds(0, 350, 410, 50);
        Dwhitepanel.setBorder(border1);
        Dwhitepanel.add(btn1);
 
        Dwhitepanel1 = new JPanel();
        Dwhitepanel1.setBackground(new Color(0xe8e4c9));
        Dwhitepanel1.setBounds(410, 350, 410, 50);
        Dwhitepanel1.setBorder(border1);
        Dwhitepanel1.add(btn);

 
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        if(e.getSource() == btn){
            
            this.dispose();
            Scheduler sched = new Scheduler();
            
        }
        else if(e.getSource()== btn1){

            this.dispose();
            Checker check = new Checker();

        }
        
    }

}
