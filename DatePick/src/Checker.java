import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

public class Checker extends JFrame {

    JTextField text;
    Checker(){
        Text();

        this.setVisible(true);
        this.setTitle("Check");
        this.setResizable(false);
        this.setSize(820, 500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    void Text(){

        text = new JTextField();
        text.setPreferredSize(new DimensionUIResource(100, 100));
        this.add(text);
        this.pack();
        this.setVisible(true);
    }
    
}
